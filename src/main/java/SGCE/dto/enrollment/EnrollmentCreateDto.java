package SGCE.dto.enrollment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EnrollmentCreateDto {
    private String fileNumber;
    private int dni;
    private String code;
}
