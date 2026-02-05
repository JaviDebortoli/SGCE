package SGCE.service;

import SGCE.domain.Course;
import SGCE.dto.CourseDto;
import SGCE.dto.StudentDto;
import SGCE.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void createCourse(CourseDto course) {
        courseRepository.save(new Course(
                course.getCourseName(),
                course.getDescription()
                )
        );
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseDto::toCourseDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CourseDto getCourseById(Long idCourse) {
        return courseRepository.findById(idCourse).map(CourseDto::toCourseDto)
                .orElse(null);
    }

    public long getCourseCount() {
        return courseRepository.count();
    }
}