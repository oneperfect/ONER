package com.demon.admin.system.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/06
 */
@Entity
@Table(name = "sys_dept")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Dept implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 部门编号
    private Long id;

    private String title;// 部门名称

    private Long pid;// 父级编号

    private String pids;// 所有父级编号

    private Long sort;// 排序

    private String remark;// 备注

    @CreatedDate
    private Date createDate;// 创建时间

    @LastModifiedDate
    private Date updateDate;// 更新时间


    public Dept() {
    }
}
