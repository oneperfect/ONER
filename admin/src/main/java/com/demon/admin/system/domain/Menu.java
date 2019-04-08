package com.demon.admin.system.domain;

import com.demon.admin.core.enums.UserStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.*;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
@Entity
@Table(name = "sys_menu")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// 主键ID
    private String title;// 菜单名称
    private Long pid;// 父级编号
    private String pids;// 所有父级编号
    private String url;// URL地址
    private String icon;// 图标
    private Byte type;// 菜单类型
    private Integer sort;// 排序
    private String remake;// 备注

    @CreatedDate
    private Date createDate;// 创建时间

    @LastModifiedDate
    private Date updateDate;// 更新时间

    @JsonIgnore
    @CreatedBy
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="create_by")
    private User createBy;// 创建用户

    @JsonIgnore
    @LastModifiedBy
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="update_by")
    private User updateBy;// 更新用户

    private Byte status = UserStatusEnum.OK.getCode();// 用户状态

    @JsonIgnore
    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles = new HashSet<>(0);

    @JsonIgnore
    @Transient
    public Map<Long, Menu> children = new HashMap<>();
}
