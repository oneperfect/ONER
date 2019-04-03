package com.demon.admin.system.service;

import com.demon.admin.system.domain.Menu;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
public interface MenuService {

    List<Menu> getList(Example<Menu> example, Sort sort);

    List<Menu> getList(Sort sort);
}
