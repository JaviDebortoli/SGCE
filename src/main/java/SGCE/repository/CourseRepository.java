package SGCE.repository;

import SGCE.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Verifica que el codigo del curso sea único
    boolean existsCourseByCode(String code);
    // Recuperar todos los cursos activos
    List<Course> findByIsActiveTrue();
}