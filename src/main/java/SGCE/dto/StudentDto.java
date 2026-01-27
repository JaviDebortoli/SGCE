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

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(
                student.getIdStudent(),
                student.getStudentName(),
                student.getEmail()
        );
    }
}