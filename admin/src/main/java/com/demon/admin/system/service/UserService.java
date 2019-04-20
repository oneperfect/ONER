package com.demon.admin.system.service;

import com.demon.admin.system.domain.User;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
public interface UserService {

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @param status 用户状态
     */
    User findByUsername(String username, Byte... status);

    /**
     * 通过用户ID查找用户
     * @param id 用户ID
     */
    User findById(Long id);

    /**
     * 保存用户数据
     * @param user 用户数据
     */
    User save(User user);


}
