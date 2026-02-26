package SGCE.service;

import SGCE.domain.Student;
import SGCE.dto.student.StudentCreateDto;
import SGCE.dto.student.StudentDto;
import SGCE.dto.student.StudentUpdateDto;
import SGCE.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public void createStudent(StudentCreateDto studentCreateDto) {
        // Crear el nuevo estudiante
        Student student = new Student();
        student.setDni(studentCreateDto.dni());
        student.setStudentName(studentCreateDto.studentName());
        student.setEmail(studentCreateDto.email());
        student.setActive(true);

        try {
            // Guardar el nuevo estudiante
            studentRepository.save(student);
        } catch (DataIntegrityViolationException exception) {
            // Lanzar excepcion por datos ya existentes
            throw new IllegalArgumentException("Email or DNI already registered");
        }
    }

    public List<StudentDto> getAllStudents() {
        // Recupera todos los estudiantes como lista
        return studentRepository.findByIsActiveTrue()
                .stream()
                .map(StudentDto::toStudentDto)
                .toList();
    }

    @Transactional
    public void updateStudent(Long idStudent, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id " + idStudent
                ));
        // Validación de email
        if (!student.getEmail().equals(studentUpdateDto.email())
                && studentRepository.existsByEmail(studentUpdateDto.email())) {
            throw new IllegalArgumentException("Email already registered");
        }
        // Actualizar estudiante
        student.setStudentName(studentUpdateDto.studentName());
        student.setEmail(studentUpdateDto.email());
    }

    @Transactional
    public void deleteStudent(Long idStudent) {
        // Buscar estudiante existente
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + idStudent
                ));
        // Actualizar estado
        student.setActive(false);
    }

    public StudentDto getStudentById(Long idStudent) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + idStudent
                ));

        return StudentDto.toStudentDto(student);
    }

    public long getStudentCount() { return studentRepository.countByIsActiveTrue(); }
}