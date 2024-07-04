package com.rony.AuthService_JWT.repository;

import com.rony.AuthService_JWT.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
