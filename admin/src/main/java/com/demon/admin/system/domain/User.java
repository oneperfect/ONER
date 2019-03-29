package com.demon.admin.system.domain;

import lombok.Getter;
import lombok.Setter;
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

    private Long isRole;// 是否拥有角色

    private String remake;// 备注

    @CreatedDate
    private Date createDate;// 创建时间

    @LastModifiedDate
    private Date updateDate;// 更新时间

    private Byte status;// 状态

    public User() {
    }

}
