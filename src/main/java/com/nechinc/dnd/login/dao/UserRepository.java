package com.nechinc.dnd.login.dao;

import com.nechinc.dnd.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String email);
}

