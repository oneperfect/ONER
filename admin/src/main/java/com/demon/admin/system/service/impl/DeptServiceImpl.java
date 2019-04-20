package com.demon.admin.system.service.impl;

import com.demon.admin.system.repository.DeptRepository;
import com.demon.admin.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

}
