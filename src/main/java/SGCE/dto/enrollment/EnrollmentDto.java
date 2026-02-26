package SGCE.dto.enrollment;

import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import java.time.LocalDateTime;
import java.util.Set;

public record EnrollmentDto (
    Long idEnrollment,
    String status,
    LocalDateTime createdAt,
    String fileNumber,
    boolean isActive,
    String courseName,
    String studentName,
    Set<EnrollmentStatus> allowedStatuses
) {
    public static EnrollmentDto toEnrollmentDto(Enrollment enrollment) {
        return new EnrollmentDto(
                enrollment.getIdEnrollment(),
                enrollment.getStatus().name(),
                enrollment.getCreatedAt(),
                enrollment.getFileNumber(),
                enrollment.isActive(),
                enrollment.getCourse().getCourseName(),
                enrollment.getStudent().getStudentName(),
                enrollment.getStatus().allowedTransitions()
        );
    }
}