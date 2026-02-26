package SGCE.dto.enrollment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnrollmentCreateDto (
        @NotBlank(message = "It cannot be empty")
        @Pattern(regexp = "^FILE-\\d{3}-\\d{4}$", message = "Must follow format FILE-123-YYYY")
        String fileNumber,

        @NotBlank(message = "It cannot be empty")
        @Pattern(regexp = "\\d{8}", message = "Must have 8 digits")
        String dni,

        @NotBlank(message = "It cannot be empty")
        @Pattern(
                regexp = "^[A-Z]{1,10}[0-9]{3}$",
                message = "Must contain up to 10 uppercase letters followed by exactly 3 numbers"
        )
        String code
) {}
