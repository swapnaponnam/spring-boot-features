package com.spring.springbootfeatures.repository;

import com.spring.springbootfeatures.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
