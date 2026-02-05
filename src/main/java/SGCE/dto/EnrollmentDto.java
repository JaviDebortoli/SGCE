package SGCE.dto;

import SGCE.domain.Enrollment;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDto {
    private Long idEnrollment;
    private String status;
    private LocalDate date;
    private Long idStudent;
    private Long idCourse;

    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        return new EnrollmentDto(
                enrollment.getIdEnrollment(),
                enrollment.getStatus().toString(),
                enrollment.getDate(),
                enrollment.getCourse().getIdCourse(),
                enrollment.getStudent().getIdStudent()
                );
    }
}