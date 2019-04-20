package com.demon.admin.system.service.impl;

import com.demon.admin.core.enums.StatusEnum;
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
    public User findByUsername(String username, Byte... status) {
        Byte[] newStatus = new Byte[status.length + 1];
        newStatus[0] = StatusEnum.OK.getCode();
        System.arraycopy(status, 0, newStatus, 1, status.length);
        return userRepository.findByUsernameAndStatusIn(username, newStatus);
    }

    @Override
    public User findById(Long id) {
        Byte[] status = {StatusEnum.OK.getCode(), StatusEnum.FREEZED.getCode()};
        return userRepository.findByIdAndStatusIn(id, status);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
