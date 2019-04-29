package com.demon.admin.system.service;

import com.demon.admin.system.domain.Dept;
import com.demon.admin.system.repository.DeptRepository;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
public interface DeptService {

    /**
     * 根据ID查找子级部门
     * @param id [id]形式
     */
    List<Dept> findByPidsLike(Long id);

}
