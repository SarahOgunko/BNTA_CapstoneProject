package com.example.RainforestRetail.repositories;import com.example.RainforestRetail.models.User;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;public interface UserRepository extends JpaRepository <User, Long> {    @Query    User findByEmail(String email);}