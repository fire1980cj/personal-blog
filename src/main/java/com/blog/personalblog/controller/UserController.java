package com.blog.personalblog.controller;

import cn.hutool.core.util.StrUtil;
import com.blog.personalblog.entity.ErrorCode;
import com.blog.personalblog.entity.LoginModel;
import com.blog.personalblog.entity.User;
import com.blog.personalblog.service.UserService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.MD5Util;
import com.blog.personalblog.util.PhoneUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "用户列表")
    @PostMapping("/list")
    public JsonResult<Object> list() {
        List<User> userList = userService.findAll();
        return JsonResult.success(userList);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户")
    @PostMapping("/create")
    public JsonResult<Object> userCreate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.createUser(user);
        return JsonResult.success();
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    public JsonResult<Object> userUpdate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.updateUser(user);
        return JsonResult.success();
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/delete/{id}")
    public JsonResult<Object> userDelete(@PathVariable(value = "id") int id) {
        userService.deleteUer(id);
        return JsonResult.success();
    }

    /**
     * 登录
     * @param loginModel
     * @return
     */
    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody LoginModel loginModel) {
        logger.info("【{}】在请求登录！", loginModel.getUsername());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginModel.getUsername(), loginModel.getPassword(), false);
        try {
            subject.login(token);
            Map<String, Object> ret = new HashMap<>();
            ret.put("token", subject.getSession().getId());
            logger.info("{} login success", loginModel.getUsername());
            return JsonResult.success(ret);
        } catch (IncorrectCredentialsException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.NOT_LOGIN);
        } catch (LockedAccountException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.ERROR_CODE);
        } catch (AuthenticationException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.USER_NOT_EXIST);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.ERROR_CODE);
        }
    }

    /**
     * 登录info信息
     *
     * @return
     */
    @GetMapping("/info")
    public JsonResult<Object> info() {
        Subject subject=SecurityUtils.getSubject();
        String username=(String) subject.getPrincipal();
        User user=userService.getUserByUserName(username);
        Map<String, Object> ret = new HashMap<>(3);
        ret.put("roles", "[admin]");
        ret.put("name", user.getUserName());
        ret.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return JsonResult.success(ret);
    }

    /**
     * 登出
     * @return
     */
    @PostMapping("/logout")
    public JsonResult<Object> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JsonResult.success("成功登出");
    }

    /**
     * 登录地址错误，重定向接口
     * @return
     */
    @RequestMapping("/unauth")
    public JsonResult<Object> unauth() {
        return JsonResult.error(ErrorCode.NOT_LOGIN);
    }
}
