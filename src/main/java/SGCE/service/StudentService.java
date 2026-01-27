package SGCE.service;

import SGCE.domain.Student;
import SGCE.dto.StudentDto;
import SGCE.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(StudentDto studentDto) {
        studentRepository.save(new Student(
                studentDto.getStudentName(),
                studentDto.getEmail()
                )
        );
    }

    @Transactional(readOnly = true)
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDto::toStudentDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public StudentDto getStudentById(Long idStudent) {
        return studentRepository.findById(idStudent).map(StudentDto::toStudentDto)
                .orElse(null);
    }
}
