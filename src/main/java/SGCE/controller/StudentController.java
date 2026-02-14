package SGCE.controller;

import SGCE.dto.student.StudentCreateDto;
import SGCE.dto.student.StudentUpdateDto;
import SGCE.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/students";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute StudentCreateDto student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @PutMapping
    public String updateStudent(@ModelAttribute StudentUpdateDto student) {
        studentService.updateStudent(student);
        return "redirect:/students-update";
    }
}