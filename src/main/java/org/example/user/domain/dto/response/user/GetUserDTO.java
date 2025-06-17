package org.example.user.domain.dto.response.user;

import java.util.UUID;

public record GetUserDTO(
        UUID id,
        String name,
        String email
) {}
