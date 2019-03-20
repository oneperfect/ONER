package com.demon.admin.system.repository;

import com.demon.admin.system.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/09
 */
public interface UserRepository extends BaseRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findUserByUsername(String username);
}
