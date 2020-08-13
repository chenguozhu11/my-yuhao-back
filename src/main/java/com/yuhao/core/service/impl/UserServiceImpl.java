package com.yuhao.core.service.impl;

import com.yuhao.core.entity.User;
import com.yuhao.core.mapper.UserMapper;
import com.yuhao.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public User checkAccount(User user) {
        User userInfo = userMapper.checkAccount(user);
        return userInfo;
    }
}
