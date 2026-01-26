package SGCE.repository;

import SGCE.domain.Course;
import SGCE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentEmail(String studentEmail);
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}