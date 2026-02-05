package SGCE.service;

import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
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
    public void enrollStudent(Long idStudent, Long idCourse) {
        enrollmentRepository.save(new Enrollment(
                EnrollmentStatus.ACTIVE,
                LocalDate.now(),
                studentRepository.findById(idStudent).orElse(null),
                courseRepository.findById(idCourse).orElse(null)
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

    public long getEnrollmentCount() {
        return enrollmentRepository.count();
    }
}