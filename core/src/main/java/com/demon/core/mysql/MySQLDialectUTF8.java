package com.demon.core.mysql;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/14
 */
public class MySQLDialectUTF8 extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
