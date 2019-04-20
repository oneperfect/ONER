package com.demon.admin.system.repository;


import com.demon.admin.system.domain.Dict;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
public interface DictRepository extends BaseRepository<Dict, Long> {


    Dict findByNameAndStatus(String name, Byte status);

}
