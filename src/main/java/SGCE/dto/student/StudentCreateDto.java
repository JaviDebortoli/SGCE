package SGCE.dto.student;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class StudentCreateDto {
    private int dni;
    private String studentName;
    private String email;
}