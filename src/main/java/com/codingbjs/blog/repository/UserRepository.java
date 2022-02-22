package com.codingbjs.blog.repository;

import com.codingbjs.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
