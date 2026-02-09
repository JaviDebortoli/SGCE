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

    @Transactional
    public void createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setEmail(studentDto.getEmail());
        student.setActive(true);

        studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDto::toStudentDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public long getStudentCount() {
        return studentRepository.count();
    }


}