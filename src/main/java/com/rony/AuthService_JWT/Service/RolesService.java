package com.rony.AuthService_JWT.Service;

import com.rony.AuthService_JWT.entity.Roles;
import com.rony.AuthService_JWT.repository.RolesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<Roles> findAllRoles(){
        return rolesRepository.findAll();
    }
}
