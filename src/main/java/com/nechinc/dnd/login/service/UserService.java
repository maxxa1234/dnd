package com.nechinc.dnd.login.service;

import com.nechinc.dnd.exeption.InvalidPasswordException;
import com.nechinc.dnd.exeption.UserAlreadyExistsException;
import com.nechinc.dnd.exeption.UserNotFoundException;
import com.nechinc.dnd.login.JwtTokenProvider;
import com.nechinc.dnd.login.dao.UserRepository;
import com.nechinc.dnd.user.entity.User;
import com.nechinc.dnd.login.model.LoginRequest;
import com.nechinc.dnd.login.model.RegisterRequest;
import com.nechinc.dnd.user.entity.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(String.format("User with id: %d, is not found.", id)));
    }

    public void saveUser(RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isEmpty()) {
            throw new UserAlreadyExistsException(String.format("User with username: %s, already exists.", registerRequest.getUsername()));
        }
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());
        if (!isPasswordMatch(loginRequest.getPassword(), safeUserExtract(userOpt).getPassword())) {
            throw new InvalidPasswordException("Invalid username or password.");
        } else{
            return jwtTokenProvider.generateToken(
                    safeUserExtract(userOpt).getUsername(),
                    safeUserExtract(userOpt).getId());
        }
    }

    private User safeUserExtract(Optional<User> user) {
        return user.orElseThrow(() -> new UserNotFoundException("Invalid username or password."));
    }


    public UserDto convertUserToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .characters(user.getCharacters())
                .build();
    }

    private boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
