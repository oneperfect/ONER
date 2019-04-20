package com.demon.admin.system.repository;

import com.demon.admin.system.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @Auther: oneperfect
 * @Date: 2019/03/09
 */
public interface UserRepository extends BaseRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名和状态查找用户
     * @param username 用户名
     * @param status 用户状态
     * @return 用户对象
     */
    User findByUsernameAndStatusIn(String username, Byte[] status);

    /**
     * 通过用户ID和状态查找用户列表
     * @param ids ID列表
     * @param status 用户状态
     * @return 用户对象
     */
    List<User> findByIdAndStatus(List<Long> ids, Byte status);

}
