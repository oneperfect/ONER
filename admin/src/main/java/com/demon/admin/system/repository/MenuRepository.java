package com.demon.admin.system.repository;

import com.demon.admin.system.domain.Menu;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
public interface MenuRepository extends BaseRepository<Menu, Long> {

    List<Menu> findAllByStatus(Sort sort, Byte status);
}
