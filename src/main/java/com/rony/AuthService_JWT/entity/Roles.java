package com.rony.AuthService_JWT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
public class Roles {

    @Id
    private long id;

    private String description;

    public Roles(long id, String name) {
        this.id = id;
        this.description = name;
    }

    public enum Values {
        ADMIN(1, "ADMIN"),
        USER(2, "USER");

        private final long id;
        private final String description;

        Values(long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Roles toRole() {
            return new Roles(id, description);
        }

    }
}
