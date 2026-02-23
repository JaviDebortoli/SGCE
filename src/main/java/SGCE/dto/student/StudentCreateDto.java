package SGCE.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class StudentCreateDto {
    @NotBlank(message = "It cannot be empty")
    @Pattern(regexp = "\\d{8}", message = "Must have 8 digits")
    private String dni;

    @NotBlank(message = "It cannot be empty")
    @Size(min = 3, max = 100, message = "Must be between 3 and 100 characters")
    private String studentName;

    @NotBlank(message = "It cannot be empty")
    @Email(message = "Must be valid")
    private String email;
}