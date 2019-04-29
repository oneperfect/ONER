package com.demon.admin.system.service.impl;

import com.demon.admin.core.enums.StatusEnum;
import com.demon.admin.system.domain.Dept;
import com.demon.admin.system.repository.DeptRepository;
import com.demon.admin.system.service.DeptService;
import com.demon.core.enums.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> findByPidsLike(Long id) {
        return deptRepository.findByPidsLikeAndStatus("%[" + id + "]%", StatusEnum.OK.getCode());
    }
}
