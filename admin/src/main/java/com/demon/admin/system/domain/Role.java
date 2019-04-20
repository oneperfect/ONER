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
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
@Entity
@Table(name = "sys_role")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// 主键ID
    private String title;// 角色名称
    private String name;// 标识名称
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

    private Byte status = StatusEnum.OK.getCode();// 用户状态

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>(0);

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_menu",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menus = new HashSet<>(0);

}