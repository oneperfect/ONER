package com.demon.admin.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/09
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {


    /**
     * 通过主键ID查找数据且排查状态
     * @param id 主键ID
     * @param status 用户状态
     * @return 用户对象
     */
    T findByIdAndStatusIn(Long id, Byte[] status);
}
