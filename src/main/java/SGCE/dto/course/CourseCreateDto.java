package SGCE.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CourseCreateDto (
    @NotBlank(message = "Course code is required")
    @Pattern(
            regexp = "^[A-Z]{1,10}[0-9]{3}$",
            message = "Code must contain up to 10 uppercase letters followed by exactly 3 numbers"
    )
    String code,

    @NotBlank(message = "It cannot be empty")
    @Size(min = 3, max = 100, message = "Must be between 3 and 100 characters")
    String courseName,

    @NotBlank(message = "It cannot be empty")
    @Size(min = 3, max = 1000, message = "Must be between 3 and 1000 characters")
    String description
) {}
