package org.example.user.application;

import org.example.user.domain.exception.DefaultException;
import org.example.user.domain.model.User;
import org.example.user.domain.dto.request.CreateUserDTO;
import org.example.user.domain.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(CreateUserDTO receivedUser) {
        try {
            User newUser = new User();
            newUser.setName(receivedUser.name());
            newUser.setEmail(receivedUser.email());
            newUser.setPassword(receivedUser.password());
            this.userRepository.saveUser(newUser);

            throw new DefaultException(500, "Testando o error");
        } catch (Exception ex) {
            throw new DefaultException(500, "Error saving new user");
        }
    }
}
