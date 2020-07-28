package com.kyriexu.service.impl;

import com.kyriexu.exception.GlobalException;
import com.kyriexu.mapper.UserMapper;
import com.kyriexu.model.User;
import com.kyriexu.service.UserService;
import com.kyriexu.utils.ValidateUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/7/28 13:14
 **/
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword()))
            throw new GlobalException("添加失败，请检查用户名密码是否输入");
        if (!ValidateUserInfo.validateEmail(user.getEmail()))
            throw new GlobalException("请检查邮箱格式是否符合要求");
        if(userMapper.getUserByUsername(user.getUsername())!=null)
            throw new GlobalException("此用户名已被占用");
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userMapper.addUser(user);
    }

    @Override
    public boolean deleteUser(String username) {
        boolean res = false;
        if (ValidateUserInfo.validateUsername(username))
            res = userMapper.deleteUser(username);
        return res;
    }

    @Override
    public boolean updateUser(User user) {
        if(StringUtils.hasText(user.getPassword()))
            // 加密
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userMapper.updateUser(user);
    }
}
