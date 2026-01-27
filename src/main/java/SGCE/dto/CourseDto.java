package SGCE.dto;

import SGCE.domain.Course;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private Long idCourse;
    private String courseName;
    private String courseDescription;

    public static CourseDto toCourseDto(Course course) {
        return new CourseDto(
                course.getIdCourse(),
                course.getCourseName(),
                course.getDescription()
        );
    }
}