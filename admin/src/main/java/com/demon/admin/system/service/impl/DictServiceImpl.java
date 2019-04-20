package com.demon.admin.system.service.impl;

import com.demon.admin.core.enums.StatusEnum;
import com.demon.admin.system.domain.Dict;
import com.demon.admin.system.repository.DictRepository;
import com.demon.admin.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictRepository dictRepository;

    @Override
    public Dict findByName(String name) {
        return dictRepository.findByNameAndStatus(name, StatusEnum.OK.getCode());
    }
}
