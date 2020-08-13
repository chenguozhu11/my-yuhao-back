package com.yuhao.core.mapper;

import com.yuhao.core.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectUserList();

    User checkAccount(User user);
}
