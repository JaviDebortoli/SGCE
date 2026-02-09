package SGCE.service;

import SGCE.domain.Course;
import SGCE.dto.course.CourseCreateDto;
import SGCE.dto.course.CourseDto;
import SGCE.dto.course.CourseUpdateDto;
import SGCE.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public void createCourse(CourseCreateDto courseCreateDto) {
        // Verificar que el codigo sea único
        if ( courseRepository.existsCourseByCode(courseCreateDto.getCode()) ) {
            throw new IllegalArgumentException("Code already exists");
        }
        // Crear nuevo curso
        Course course = new Course();
        course.setCode(courseCreateDto.getCode());
        course.setCourseName(courseCreateDto.getCourseName());
        course.setDescription(courseCreateDto.getDescription());
        // Guardar nuevo curso
        courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        return courseRepository.findByIsActiveTrue()
                .stream()
                .map(CourseDto::toCourseDto)
                .toList();
    }

    @Transactional
    public void updateCourse(Long idCourse, CourseUpdateDto courseUpdateDto) {
        // Buscar curso existente
        Course course = courseRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + idCourse
                ));
        // Actualizar estado del curso
        course.setActive(courseUpdateDto.isActive());
        // Guardar cambios
        courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(Long idCourse) {
        // Buscar curso existente
        Course course = courseRepository.findById(idCourse)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + idCourse
                ));
        // Actualizar estado
        course.setActive(false);
        // Guardar cambios
        courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public long getCourseCount() { return courseRepository.count(); }
}