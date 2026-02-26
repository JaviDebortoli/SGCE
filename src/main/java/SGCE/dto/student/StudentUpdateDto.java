package SGCE.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentUpdateDto (
        String dni,

        @NotBlank(message = "It cannot be empty")
        @Size(min = 3, max = 100, message = "Must be between 3 and 100 characters")
        String studentName,

        @NotBlank(message = "It cannot be empty")
        @Email(message = "Must be valid")
        String email
) {}
