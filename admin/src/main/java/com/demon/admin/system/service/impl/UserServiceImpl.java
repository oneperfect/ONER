package com.demon.admin.system.service.impl;

import com.demon.admin.core.enums.StatusEnum;
import com.demon.admin.core.web.PageSort;
import com.demon.admin.system.domain.Dept;
import com.demon.admin.system.domain.User;
import com.demon.admin.system.repository.UserRepository;
import com.demon.admin.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username, Byte... status) {
        Byte[] newStatus = new Byte[status.length + 1];
        newStatus[0] = StatusEnum.OK.getCode();
        System.arraycopy(status, 0, newStatus, 1, status.length);
        return userRepository.findByUsernameAndStatusIn(username, newStatus);
    }

    @Override
    public User findById(Long id) {
        Byte[] status = {StatusEnum.OK.getCode(), StatusEnum.FREEZED.getCode()};
        return userRepository.findByIdAndStatusIn(id, status);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findPageList(User user, List<Long> depts) {
        // 创建分页对象
        PageRequest page = PageSort.pageRequest(Sort.Direction.ASC.toString());
        return userRepository.findAll(new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> preList = new ArrayList<>();

                if(user.getUsername() != null){
                    preList.add(cb.equal(root.get("username").as(String.class), user.getUsername()));
                }
                if(user.getNickname() != null){
                    preList.add(cb.like(root.get("nickname").as(String.class), "%"+ user.getNickname() + "%"));
                }
                if(depts != null){
                    Join<User, Dept> join = root.join("dept", JoinType.INNER);
                    CriteriaBuilder.In<Long> in = cb.in(join.get("id").as(Long.class));
                    depts.forEach(in::value);
                    preList.add(in);
                }

                // 数据状态
                if(!user.getStatus().equals(StatusEnum.DELETE.getCode())){
                    preList.add(cb.equal(root.get("status").as(Byte.class), user.getStatus()));
                }

                Predicate[] pres = new Predicate[preList.size()];
                return query.where(preList.toArray(pres)).getRestriction();
            }
        }, page);
    }
}
