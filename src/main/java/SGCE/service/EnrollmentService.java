package SGCE.service;

import SGCE.domain.Course;
import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import SGCE.domain.Student;
import SGCE.repository.CourseRepository;
import SGCE.repository.EnrollmentRepository;
import SGCE.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {
    private final EnrollmentRepository enrollmentService;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        // Verifica que el estudiante exista
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        // Verifica que el curso exista
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        // Verifica que el estudiante no este inscripto ya al curso
        enrollmentService.findByStudentAndCourse(student, course)
                .ifPresent(e -> {
                    throw new RuntimeException("Student already enrolled");
                });
        // Crea la nueva inscripción
        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .status(EnrollmentStatus.ACTIVE)
                .date(LocalDate.now())
                .build();

        return enrollmentService.save(enrollment);
    }
}