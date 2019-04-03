package com.demon.admin.system.domain;

import com.demon.admin.core.enums.UserStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
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
    @JsonIgnore
    private Date createDate;// 创建时间
    @LastModifiedDate
    @JsonIgnore
    private Date updateDate;// 更新时间
    @CreatedBy
    @JsonIgnore
    private User createBy;// 创建用户
    @LastModifiedBy
    @JsonIgnore
    private User updateBy;// 更新用户
    @JsonIgnore
    private Byte status = UserStatusEnum.OK.getCode();// 用户状态

    @JsonIgnore
    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles = new HashSet<>(0);

    @JsonIgnore
    @Transient
    public Map<Menu, Long> children = new HashMap<>();
}
