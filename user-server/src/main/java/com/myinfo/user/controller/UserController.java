package com.myinfo.user.controller;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.controller.BaseController;
import com.myinfo.base.exception.ApiException;
import com.myinfo.user.bean.req.LoginReq;
import com.myinfo.user.bean.req.RegisterReq;
import com.myinfo.user.bean.res.LoginRes;
import com.myinfo.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Api(tags = "用户相关")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResVo<LoginRes> login(LoginReq req) {
        try {
            LoginRes result = userService.login(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public ResVo<String> register(RegisterReq req) {
        try {
            String result = userService.register(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

}
