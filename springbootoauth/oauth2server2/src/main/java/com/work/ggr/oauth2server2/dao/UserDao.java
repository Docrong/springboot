package com.work.ggr.oauth2server2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

/**
 * @author : gr
 * @date : 2019/11/4 15:24
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}