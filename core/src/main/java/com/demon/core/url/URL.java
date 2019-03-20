package com.demon.core.url;

import com.demon.core.utils.HttpServletUtil;

/**
 * 获取系统路径
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
public class URL {

    private String url;

    public URL() {

    }

    public URL (String url) {
        this.url = HttpServletUtil.getRequest().getContextPath() + url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
