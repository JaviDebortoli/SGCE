package SGCE.repository;

import SGCE.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Verifica que el codigo del curso sea único
    boolean existsCourseByCode(String code);
    // Recuperar todos los cursos activos
    List<Course> findByIsActiveTrue();
    // Recupera un curso por su código
    Optional<Course> findByCode(String code);
}