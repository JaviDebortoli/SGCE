package SGCE.service;

import SGCE.domain.Enrollment;
import SGCE.domain.EnrollmentStatus;
import SGCE.dto.enrollment.EnrollmentCreateDto;
import SGCE.dto.enrollment.EnrollmentDto;
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
@Transactional (readOnly = true)
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public void enrollStudent(EnrollmentCreateDto enrollmentCreateDto) {
        Enrollment enrollment = new Enrollment();

        enrollment.setFileNumber(enrollmentCreateDto.getFileNumber());

        // TODO: terminar este service y los controllers
    }

    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(EnrollmentDto::toEnrollmentDto)
                .toList();
    }

    public long getEnrollmentCount() { return enrollmentRepository.count(); }

    public List<EnrollmentDto> getLastEnrollmentsActivity() {
        return enrollmentRepository.findTop5ByOrderByUpdatedAtDesc()
                .stream()
                .map(EnrollmentDto::toEnrollmentDto)
                .toList();
    }
}