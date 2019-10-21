package com.msg.pigeon.controller;

import com.msg.pigeon.auth.Sessions;
import com.msg.pigeon.model.User;
import com.msg.pigeon.model.req.UserReq;
import com.msg.pigeon.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public void login(
            @RequestBody UserReq userReq,
            HttpServletRequest request, HttpServletResponse response) {
        //查询数据库获取用户
        User user = userService.login(userReq.getUserName(), userReq.getPassword());
        if (user == null) {

        } else {
            Sessions.loginUser(user.getUserId(),
                    true,
                    true,
                    "",
                    "",
                    response);
        }
    }

    @PostMapping("/user/register")
    public void register(@RequestBody @Valid UserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
    }


}
