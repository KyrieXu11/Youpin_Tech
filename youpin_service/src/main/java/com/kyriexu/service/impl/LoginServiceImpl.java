package com.kyriexu.service.impl;

import com.kyriexu.mapper.LoginMapper;
import com.kyriexu.model.User;
import com.kyriexu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:49
 **/
@Service
public class LoginServiceImpl implements LoginService {

    private LoginMapper loginMapper;

    @Autowired
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public boolean login(User user) {
        String password = loginMapper.login(user);
        return password != null && password.equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
    }
}
