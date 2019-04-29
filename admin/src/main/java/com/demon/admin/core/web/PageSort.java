package com.demon.admin.core.web;

import com.demon.core.utils.HttpServletUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @Author: oneperfect
 * @Date: 2019/4/21
 */
public class PageSort {

    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final String DEFAULT_ORDER_BY = "createDate";
    private static final String ASC_OR_DESC = "desc";

    /**
     * 创建分页排序对象
     */
    public static PageRequest pageRequest() {
        return pageRequest(DEFAULT_PAGE_SIZE, DEFAULT_ORDER_BY, ASC_OR_DESC);
    }

    /**
     * 创建分页排序对象，有默认值
     * @param ascDesc 升序或者降序
     */
    public static PageRequest pageRequest(String ascDesc) {
        return pageRequest(DEFAULT_PAGE_SIZE, DEFAULT_ORDER_BY, ascDesc);
    }

    /**
     * 创建分页排序对象，有默认值
     * @param orderBy 默认排序字段名
     * @param ascDesc 升序或者降序
     */
    public static PageRequest pageRequest(String orderBy, String ascDesc) {
        return pageRequest(DEFAULT_PAGE_SIZE, orderBy, ascDesc);
    }

    /**
     * 创建分页排序对象，有默认值
     * @param size 默认分页显示条数
     * @param orderBy 默认排序字段名
     * @param ascDesc 升序或者降序
     */
    public static PageRequest pageRequest(Integer size, String orderBy, String ascDesc) {
        Integer pageIndex = HttpServletUtil.getParameterInt("page", 1);
        Integer pageSize = HttpServletUtil.getParameterInt("size", size);
        String order = HttpServletUtil.getParameter("orderBy", orderBy);
        String direction = HttpServletUtil.getParameter("ascDesc", ascDesc);
        Sort sort = new Sort(Sort.Direction.fromString(direction), order);
        return PageRequest.of(pageIndex-1, pageSize, sort);
    }

}