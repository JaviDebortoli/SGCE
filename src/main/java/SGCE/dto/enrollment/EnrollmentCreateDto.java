package SGCE.dto.enrollment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class EnrollmentCreateDto {
    private String fileNumber;
    private String courseName;
    private String studentName;
}
