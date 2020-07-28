package com.kyriexu.mapper;

import com.kyriexu.model.User;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:54
 **/
public interface LoginMapper {
    public abstract String login(User user);
}
