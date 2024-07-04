package com.rony.AuthService_JWT.config;

import com.rony.AuthService_JWT.entity.Roles;
import com.rony.AuthService_JWT.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RolesRepository rolesRepository;

    public DataLoader(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Roles.Values.values())
                .map(Roles.Values::toRole)
                .forEach(rolesRepository::save);
    }
}
