package com.demon.admin.system.repository;

import com.demon.admin.system.domain.Dept;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
public interface DeptRepository extends BaseRepository<Dept, Long> {

    /**
     * 根据父ID查找子孙部门
     * @param pids pid列表
     */
    List<Dept> findByPidsLikeAndStatus(String pids, Byte status);

}
