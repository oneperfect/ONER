package com.demon.admin.system.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String salt;
    private Long deptId;
    private String picture;
    private String sex;
    private String email;
    private String phone;
    private Long isRole;
    private String remake;
    @CreatedDate
    private Date createDate;
    private Date updateDate;
    private Long status;

    public User() {
    }
}
