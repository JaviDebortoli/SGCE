package SGCE.service;

import SGCE.domain.Student;
import SGCE.dto.student.StudentCreateDto;
import SGCE.dto.student.StudentDto;
import SGCE.dto.student.StudentUpdateDto;
import SGCE.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
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
        // Verificar que el email sea único
        if ( studentRepository.existsByEmail(studentCreateDto.getEmail()) ) {
            throw new IllegalArgumentException("Email already registered");
        }
        // Crear el nuevo estudiante
        Student student = new Student();
        student.setStudentName(studentCreateDto.getStudentName());
        student.setEmail(studentCreateDto.getEmail());
        student.setActive(true);
        // Guardar el nuevo estudiante
        studentRepository.save(student);
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
        // Buscar estudiante existente
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id " + idStudent
                ));
        // Actualizar campos permitidos
        student.setStudentName(studentUpdateDto.getStudentName());
        student.setEmail(studentUpdateDto.getEmail());
        // Guardar cambios
        studentRepository.save(student);
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
        // Guardar cambios
        studentRepository.save(student);
    }

    public StudentDto getStudentById(Long idStudent) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found with id: " + idStudent
                ));

        return StudentDto.toStudentDto(student);
    }

    public long getStudentCount() {
        return studentRepository.countByIsActiveTrue();
    }
}