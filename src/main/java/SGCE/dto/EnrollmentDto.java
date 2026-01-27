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
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
    private String status;


    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        return new EnrollmentDto(
                enrollment.getIdEnrollment(),
                enrollment.getStudent().getStudentName(),
                enrollment.getCourse().getCourseName(),
                enrollment.getDate(),
                enrollment.getStatus().name()
        );
    }
}