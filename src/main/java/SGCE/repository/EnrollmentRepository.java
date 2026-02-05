package SGCE.repository;

import SGCE.domain.Course;
import SGCE.domain.Enrollment;
import SGCE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> { }