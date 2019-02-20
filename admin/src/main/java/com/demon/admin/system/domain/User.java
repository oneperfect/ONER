package com.demon.admin.system.domain;

import java.util.Date;

public class User {

    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String salt;
    private Long deptId;
    private String picture;
    private String sex;
    private String email;
    private String phone;
    private Long isRole;
    private String remake;
    private Date createDate;
    private Date updateDate;
    private Long status;

    public User() {
    }
}
