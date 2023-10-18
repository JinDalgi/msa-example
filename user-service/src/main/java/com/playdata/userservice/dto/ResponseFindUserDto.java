package com.playdata.userservice.dto;

import com.playdata.userservice.domain.User;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder @ToString
public class ResponseFindUserDto {
    private String uuid;

    private Long id;

    private String email;

    private String name;

    private String userId;

    public ResponseFindUserDto(User user) {
        this.uuid = user.getUuid();
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
    }

    public void setOrderList(List<Object> of) {
    }
}
