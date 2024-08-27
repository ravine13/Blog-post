package com.rein.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rein.Blog.Entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findUserById(@Param("id") Integer id);

    Optional<User> findByUsername(String username);
}
