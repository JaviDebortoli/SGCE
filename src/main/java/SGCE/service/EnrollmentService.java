package SGCE.service;

import SGCE.domain.Course;
import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import SGCE.domain.Student;
import SGCE.dto.enrollment.EnrollmentCreateDto;
import SGCE.dto.enrollment.EnrollmentDto;
import SGCE.repository.CourseRepository;
import SGCE.repository.EnrollmentRepository;
import SGCE.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public void createEnrollment(EnrollmentCreateDto enrollmentCreateDto) {
        // Encontrar el estudiante
        Student student = studentRepository.findByDni(enrollmentCreateDto.getDni())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with DNI: " + enrollmentCreateDto.getDni()
                ));
        // Encontrar el curso
        Course course = courseRepository.findByCode(enrollmentCreateDto.getCode())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Course not found with Code: " + enrollmentCreateDto.getCode()
                ));
        // Crear inscripcion
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setFileNumber(enrollmentCreateDto.getFileNumber());
        enrollment.setActive(true);
        // Guardar la inscripcion
        enrollmentRepository.save(enrollment);
    }

    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentRepository.findByIsActiveTrue()
                .stream()
                .map(EnrollmentDto::toEnrollmentDto)
                .toList();
    }

    public long getEnrollmentCount() {
        return enrollmentRepository.countByStatusAndIsActiveTrue(EnrollmentStatus.ACTIVE);
    }

    public List<EnrollmentDto> getLastEnrollmentsActivity() {
        return enrollmentRepository.findTop5ByIsActiveTrueOrderByUpdatedAtDesc()
                .stream()
                .map(EnrollmentDto::toEnrollmentDto)
                .toList();
    }

    @Transactional
    public void deleteEnrollment(Long idEnrollment) {
        // Buscar la inscripcion
        Enrollment enrollment = enrollmentRepository.findById(idEnrollment)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Enrollment not found with id: " + idEnrollment
                ));
        // Borrado lógico
        enrollment.setActive(false);
    }

    @Transactional
    public void changeEnrollmentStatus(Long idEnrollment, EnrollmentStatus status) {
        // Buscar la inscripcion
        Enrollment enrollment = enrollmentRepository.findById(idEnrollment)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Enrollment not found with id: " + idEnrollment
                ));
        // Cambiar estado
        enrollment.changeStatus(status);
    }
}