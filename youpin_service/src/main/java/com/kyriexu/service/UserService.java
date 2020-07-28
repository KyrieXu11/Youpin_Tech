package com.kyriexu.service;

import com.kyriexu.model.User;

import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/7/28 13:12
 **/
public interface UserService {
    public abstract List<User> getAllUsers();

    public abstract boolean addUser(User user);

    public abstract boolean deleteUser(String username);

    public abstract boolean updateUser(User user);
}
