package org.example.user.application.user;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.user.domain.dto.response.user.GetUserDTO;
import org.example.user.domain.exception.DefaultException;
import org.example.user.domain.model.User;
import org.example.user.domain.dto.request.user.CreateUserDTO;
import org.example.user.domain.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<GetUserDTO> findById(UUID id){
        try {
            User user = this.userRepository.findById(id);

            return Optional.of(new GetUserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail()
            ));
        } catch (Exception ex) {
            throw new DefaultException(500, "Error finding user");
        }
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
