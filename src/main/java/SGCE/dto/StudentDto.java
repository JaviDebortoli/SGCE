package SGCE.dto;

import SGCE.domain.Student;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long idStudent;
    private String studentName;
    private String email;
    private boolean isActive;

    public static StudentDto toStudentDto(Student student) {
        return StudentDto.builder()
                .idStudent(student.getIdStudent())
                .studentName(student.getStudentName())
                .email(student.getEmail())
                .isActive(student.isActive())
                .build();
    }
}