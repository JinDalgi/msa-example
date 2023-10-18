package com.playdata.userservice.service;

import com.playdata.userservice.domain.User;
import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.dto.ResponseFindUserDto;
import com.playdata.userservice.exception.UserNotFoundException;
import com.playdata.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(RequestCreateUserDto userDto) {
        // dto를 entity로 변경해주는 작업이 필요
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public ResponseFindUserDto findUserByUuid(String uuid) {
        User user = userRepository.findUserByUuid(uuid);

        if (user == null) throw new UserNotFoundException("해당 유저는 존재하지 않습니다.");

        ResponseFindUserDto dto = new ResponseFindUserDto(user);
        dto.setOrderList(List.of());

        return dto;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

}
