package com.rony.AuthService_JWT.repository;

import com.rony.AuthService_JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
