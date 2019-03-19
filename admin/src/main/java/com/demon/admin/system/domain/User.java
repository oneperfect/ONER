package com.demon.admin.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "sys_user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {

    // 用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 用户名
    private String username;
    // 用户昵称
    private String nickname;
    // 用户密码
    private String password;
    // 密码盐
    private String salt;
    // 部门id
    private Long deptId;
    // 用户头像
    private String picture;
    // 性别
    private String sex;
    // 邮箱
    private String email;
    // 电话号码
    private String phone;
    // 是否拥有角色
    private Long isRole;
    // 备注
    private String remake;
    // 创建时间
    @CreatedDate
    private Date createDate;
    // 更新时间
    @LastModifiedDate
    private Date updateDate;
    // 状态
    private Byte status;

    public User() {
    }

}
