package com.demon.admin.system.domain;

import com.demon.admin.core.enums.UserIsRoleEnum;
import com.demon.admin.core.enums.UserStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/06
 */
@Entity
@Table(name = "sys_user")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    // 用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 用户名

    private String nickname;// 用户昵称

    private String password;// 用户密码

    private String salt;// 密码盐

    private Long deptId;// 部门id

    private String picture;// 用户头像

    private String sex;// 性别

    private String email;// 邮箱

    private String phone;// 电话号码

    private String remake;// 备注

    @JsonIgnore
    @CreatedDate
    private Date createDate;// 创建时间

    @JsonIgnore
    @LastModifiedDate
    private Date updateDate;// 更新时间

    @JsonIgnore
    private Byte status = UserStatusEnum.OK.getCode();// 状态

    @JsonIgnore
    private Byte isRole = UserIsRoleEnum.YES.getCode();// 是否拥有角色

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sys_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>(0);

}
