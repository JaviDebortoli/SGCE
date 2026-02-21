package SGCE.repository;

import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Recupera las ultimas 5 incripciones activas
    List<Enrollment> findTop5ByIsActiveTrueOrderByUpdatedAtDesc();
    // Recupera las incripciones activas y con status = ACTIVE
    long countByStatusAndIsActiveTrue(EnrollmentStatus status);
    // Recupera las incripciones activas
    List<Enrollment> findByIsActiveTrue();
}