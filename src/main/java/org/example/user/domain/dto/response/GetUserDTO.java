package org.example.user.domain.dto.response;

import java.util.UUID;

public record GetUserDTO(
        UUID id,
        String name,
        String email
) {}
