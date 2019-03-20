package com.demon.admin.system.service.impl;

import com.demon.admin.system.domain.User;
import com.demon.admin.system.repository.UserRepository;
import com.demon.admin.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findUserByUsername(username);
    }
}
