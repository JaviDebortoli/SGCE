package SGCE.dto.enrollment;

import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDto {
    private Long idEnrollment;
    private String status;
    private LocalDateTime createdAt;
    private String fileNumber;
    private boolean isActive;
    private String courseName;
    private String studentName;
    private Set<EnrollmentStatus> allowedStatuses;

    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        return EnrollmentDto.builder()
                .idEnrollment(enrollment.getIdEnrollment())
                .status(enrollment.getStatus().name())
                .createdAt(enrollment.getCreatedAt())
                .fileNumber(enrollment.getFileNumber())
                .isActive(enrollment.isActive())
                .courseName(enrollment.getCourse().getCourseName())
                .studentName(enrollment.getStudent().getStudentName())
                .allowedStatuses(enrollment.getStatus().allowedTransitions())
                .build();
    }
}