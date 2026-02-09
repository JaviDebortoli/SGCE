package SGCE.dto.enrollment;

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
    private String fileNumber;
    private boolean isActive;
    private String courseName;
    private String studentName;

    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        return EnrollmentDto.builder()
                .idEnrollment(enrollment.getIdEnrollment())
                .status(enrollment.getStatus().name())
                .date(enrollment.getDate())
                .fileNumber(enrollment.getFileNumber())
                .isActive(enrollment.isActive())
                .courseName(enrollment.getCourse().getCourseName())
                .studentName(enrollment.getStudent().getStudentName())
                .build();
    }
}