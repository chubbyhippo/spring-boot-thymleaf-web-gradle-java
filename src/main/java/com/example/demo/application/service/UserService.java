package com.example.demo.application.service;

import com.example.demo.application.dto.UserDto;
import com.example.demo.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Page<UserDto> getUsers(Pageable pageable) {
        return repository.getUsers(pageable)
                .map(user -> UserDto.builder()
                        .name(user.getFirstname() + " " + user.getLastname())
                        .gender(user.getGender())
                        .birthday(user.getDob())
                        .phoneNumber(user.getPhoneNumber())
                        .build());
    }

}
