package SGCE.repository;

import SGCE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Verifica que un email sea único
    boolean existsByEmail(String email);
}