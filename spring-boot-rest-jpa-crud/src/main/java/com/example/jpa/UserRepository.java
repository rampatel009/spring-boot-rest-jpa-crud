package com.example.jpa;

import javax.transaction.Transactional;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
public interface UserRepository extends JpaRepository<User, String> {

}
