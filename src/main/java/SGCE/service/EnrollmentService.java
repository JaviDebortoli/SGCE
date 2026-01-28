package SGCE.service;

import SGCE.domain.Course;
import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import SGCE.domain.Student;
import SGCE.dto.EnrollmentDto;
import SGCE.repository.CourseRepository;
import SGCE.repository.EnrollmentRepository;
import SGCE.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    /*
     * Crea una inscripción
     */
    public void enrollStudent(Long studentId, Long courseId) {
        // Verifica que el estudiante exista
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));;
        // Verifica que el curso exista
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));;
        // Verifica que el estudiante no este inscripto ya al curso
        enrollmentRepository.findByStudentAndCourse(student, course)
                .ifPresent(e -> {
                    throw new RuntimeException("Student already enrolled");
                });
        // Crea la nueva inscripción
        enrollmentRepository.save(new Enrollment(
                EnrollmentStatus.ACTIVE,
                LocalDate.now(),
                student,
                course
                )
        );
    }

    /*
     * Devuelve todas las inscripciones como DTOs.
     */
    @Transactional(readOnly = true)
    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(EnrollmentDto::toEnrollmentDto)
                .toList();
    }
}