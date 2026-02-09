package SGCE.dto.student;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class StudentUpdateDto {
    private String studentName;
    private String email;
    private boolean isActive;
}
