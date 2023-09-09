package com.blog.personalblog.service;

import com.blog.personalblog.entity.User;
import io.swagger.models.auth.In;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void createUser(User user);
    void updateUser(User user);
    void deleteUer(int id);

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
    
    
}
