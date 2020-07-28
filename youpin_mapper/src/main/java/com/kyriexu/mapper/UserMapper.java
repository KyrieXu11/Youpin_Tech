package com.kyriexu.mapper;

import com.kyriexu.model.User;

import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/7/28 10:41
 **/
public interface UserMapper {
    public abstract boolean addUser(User user);

    public abstract List<User> getAllUsers();

    public abstract boolean deleteUser(String username);

    public abstract boolean updateUser(User user);

    public abstract User getUserByUsername(String username);
}
