package SGCE.repository;

import SGCE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Verifica que un email sea único
    boolean existsByEmail(String email);
    // Recupera los estudiantes activos
    List<Student> findByIsActiveTrue();
}