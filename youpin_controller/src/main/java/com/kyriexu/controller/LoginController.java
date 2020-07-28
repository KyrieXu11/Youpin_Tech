package com.kyriexu.controller;

import com.kyriexu.model.RespBean;
import com.kyriexu.model.User;
import com.kyriexu.service.LoginService;
import com.kyriexu.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:28
 **/
@RestController
public class LoginController {
    private LoginService loginService;
    private JwtUtils jwtUtils;

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/test")
    public String getToken(){
        return "测试成功啦";
    }

    @PostMapping("/login")
    public RespBean<Object> login(HttpSession session, @RequestBody User user){
        // 登陆成功
        if (loginService.login(user)) {
            session.setAttribute("user",user);
            String token = jwtUtils.createToken(user.getUsername());
            return RespBean.OK(token,"登陆成功！");
        }else
            return RespBean.ERROR("登陆失败了，请重试");
    }
}
