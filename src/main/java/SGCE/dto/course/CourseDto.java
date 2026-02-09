package SGCE.dto.course;

import SGCE.domain.Course;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private Long idCourse;
    private String code;
    private String courseName;
    private String description;
    private boolean isActive;

    public static CourseDto toCourseDto(Course course) {
        return CourseDto.builder()
                .idCourse(course.getIdCourse())
                .code(course.getCode())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .isActive(course.isActive())
                .build();
    }
}