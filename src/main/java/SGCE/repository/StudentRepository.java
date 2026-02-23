package SGCE.repository;

import SGCE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Verifica que un email sea único
    boolean existsByEmail(String email);
    // Recupera los estudiantes activos
    List<Student> findByIsActiveTrue();
    // Recupera un usuario por su dni
    Optional<Student> findByDni(String dni);
    // Cantidad de estudiantes activos
    long countByIsActiveTrue();
}