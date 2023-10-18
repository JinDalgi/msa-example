package com.playdata.userservice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String userId;

    private String password;

    private String uuid;

    private LocalDateTime createdAt;

}
