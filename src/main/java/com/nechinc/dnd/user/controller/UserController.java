package com.nechinc.dnd.user.controller;

import com.nechinc.dnd.login.service.UserService;
import com.nechinc.dnd.user.entity.User;
import com.nechinc.dnd.user.entity.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("user_id") Long userId) {

        User user = userService.getById(userId);
        return ResponseEntity.ok(userService.convertUserToDto(user));
    }
}
