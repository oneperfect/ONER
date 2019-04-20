package com.demon.admin.system.domain;

import com.demon.admin.core.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: oneperfect
 * @Date: 2019/4/12
 */
@Entity
@Table(name = "sys_dict")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Dict implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// 主键ID
    private String title;// 字典名称
    private String name;// 字典键名
    private Byte type;// 字典类型
    @Lob
    @Column(columnDefinition="TEXT")
    private String value;// 字典键值
    private String remake;// 备注
    @CreatedDate
    private Date createDate;// 创建时间

    @LastModifiedDate
    private Date updateDate;// 更新时间

    @JsonIgnore
    @CreatedBy
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="create_by")
    private User createBy;// 创建用户

    @JsonIgnore
    @LastModifiedBy
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="update_by")
    private User updateBy;// 更新用户

    private Byte status = StatusEnum.OK.getCode();// 用户状态


}
