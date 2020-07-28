package com.kyriexu.service;

import com.kyriexu.model.User;
import org.springframework.stereotype.Service;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:49
 **/
public interface LoginService {
    public abstract boolean login(User user);
}
