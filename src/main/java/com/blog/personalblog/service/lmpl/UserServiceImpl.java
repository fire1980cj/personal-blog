package com.blog.personalblog.service.lmpl;

import com.blog.personalblog.entity.User;
import com.blog.personalblog.mapper.UserMapper;
import com.blog.personalblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteUer(int id) {
        userMapper.delete(id);
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }

    @Override
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        User user = userMapper.findByUserName(userName);
        return user;
    }
}
