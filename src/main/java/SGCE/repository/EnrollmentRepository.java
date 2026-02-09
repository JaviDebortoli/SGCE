package SGCE.repository;

import SGCE.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Recupera las ultimas 5 incripciones
    List<Enrollment> findTop5ByOrderByUpdatedAtDesc();
}