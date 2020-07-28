package com.kyriexu.model;

import lombok.Data;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:12
 **/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
}
