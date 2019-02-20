package com.demon.admin.system.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@EntityListeners(AuditingEntityListener.class)
public class ActionLog {

    private Long id;
    private String name;
    private Byte type;
    private String ipaddr;
    private String  clazz;
    private String method;
    private String model;
    private Long recordId;
    private String message;
    private Date createDate;
    private User createBy;

    public ActionLog() {
    }

    /**
     * 封装日志对象
     * @param name 日志名称
     * @param message 日志信息
     */
    public ActionLog(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
