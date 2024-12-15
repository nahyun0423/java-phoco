package com.example.phoco.presentation;

import com.example.phoco.application.UserService;
import com.example.phoco.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phoco/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // /user?username=TestUser
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestParam String username) {
        User savedUser = userService.saveUser(username);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
