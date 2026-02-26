package SGCE.dto.student;

import SGCE.domain.Student;
import lombok.*;

public record StudentDto (
        Long idStudent,
        String dni,
        String studentName,
        String email,
        boolean isActive
) {
    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(
                student.getIdStudent(),
                student.getDni(),
                student.getStudentName(),
                student.getEmail(),
                student.isActive()
        );
    }
}