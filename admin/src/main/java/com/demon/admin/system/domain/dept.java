package com.demon.admin.system.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_dept")
@Data
@EntityListeners(AuditingEntityListener.class)
public class dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long pid;
    private String pids;
    private Long sort;
    private String remark;
    private Date createDate;
    private Date updateDate;
    private User createBy;
    private User updateBy;
    private Long status;

}
