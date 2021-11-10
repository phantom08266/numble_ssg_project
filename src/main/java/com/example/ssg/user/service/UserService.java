package com.example.ssg.user.service;

import com.example.ssg.user.domain.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository usersRepository;

    public boolean isUserIdExist(String userId) {
        return !usersRepository.existsByUserId(userId);
    }
}
