package com.oo.kj.community.repository;

import com.oo.kj.community.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}