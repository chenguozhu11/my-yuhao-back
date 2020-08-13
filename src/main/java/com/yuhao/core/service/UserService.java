package com.yuhao.core.service;

import com.yuhao.core.entity.User;

import java.util.List;

public interface UserService {

    public List<User> selectUserList();

    public User checkAccount(User user);
}
