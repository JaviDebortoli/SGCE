package SGCE.dto.course;

import SGCE.domain.Course;

public record CourseDto (
    Long idCourse,
    String code,
    String courseName,
    String description,
    boolean isActive
) {
    public static CourseDto toCourseDto(Course course) {
        return new CourseDto (
                course.getIdCourse(),
                course.getCode(),
                course.getCourseName(),
                course.getDescription(),
                course.isActive()
        );
    }
}