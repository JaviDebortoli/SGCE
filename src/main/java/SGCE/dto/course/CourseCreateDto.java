package SGCE.dto.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CourseCreateDto {
    private String code;
    private String courseName;
    private String description;
}
