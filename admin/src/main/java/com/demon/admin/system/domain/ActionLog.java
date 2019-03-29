package com.demon.admin.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/06
 */
@Entity
@Table(name = "sys_action_log")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ActionLog implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// 日志id

    private String name;// 日志名称

    private Byte type;// 日志类型

    private String ipaddr;// 日志操作ip地址

    private String clazz;// 产生日志的类

    private String method;// 产生日志的方法

    private String model;// 产生日志的表

    private Long recordId;// 产生日志的用户

    @Lob
    @Column(columnDefinition = "TEXT")
    private String message;// 日志消息

    @CreatedDate
    private Date createDate;// 产生日志的时间

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by")
    @JsonIgnore
    private User createBy;// 产生日志的用户

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
