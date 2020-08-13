package com.yuhao.core.controller;

import com.yuhao.core.entity.User;
import com.yuhao.core.service.UserService;
import com.yuhao.core.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseUtil login(@RequestBody User user) {
        if (user == null) {
            return new ResponseUtil(ResponseUtil.ResponseRet.ERROR, "null");
        }
        User userInfo = userService.checkAccount(user);
        if (userInfo == null) {
            return new ResponseUtil(ResponseUtil.ResponseRet.ERROR, "用户名密码错误");
        }

        return new ResponseUtil(ResponseUtil.ResponseRet.NORMAL, "登录成功", userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/check_token", method = RequestMethod.GET)
    public ResponseUtil checkToken(HttpServletRequest request) {

        String accessToken = request.getHeader("access-token");
        if (StringUtils.isEmpty(accessToken)) {
            return new ResponseUtil(ResponseUtil.ResponseRet.NOLOGIN, "登录过期");
        }
        User userInfo = new User();
        userInfo.setUsername("Admin");
        userInfo.setPassword("0");

        return new ResponseUtil(ResponseUtil.ResponseRet.NORMAL, "登录成功", userInfo);
    }

}
