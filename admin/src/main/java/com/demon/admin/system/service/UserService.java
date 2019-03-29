package com.demon.admin.system.service;

import com.demon.admin.system.domain.User;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
public interface UserService {


    User findUserByUsername(String username, Byte... status);
}
