package com.demon.admin.system.service.impl;

import com.demon.admin.system.domain.Menu;
import com.demon.admin.system.repository.MenuRepository;
import com.demon.admin.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getList(Example<Menu> example, Sort sort) {
        return menuRepository.findAll(example, sort);
    }

    public List<Menu> getList(Sort sort) {
        return menuRepository.findAll(sort);
    }
}
