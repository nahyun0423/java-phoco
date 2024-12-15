package com.example.phoco.application;

import com.example.phoco.domain.User;
import com.example.phoco.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수 없습니다. ID: " + userId));
    }
}
