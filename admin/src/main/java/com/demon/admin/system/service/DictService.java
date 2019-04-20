package com.demon.admin.system.service;

import com.demon.admin.system.domain.Dict;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
public interface DictService {

    Dict findByName(String name);
}
