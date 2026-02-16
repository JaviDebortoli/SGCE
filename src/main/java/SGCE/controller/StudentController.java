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

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "students/students-update";
    }

    @PostMapping("/{id}/edit")
    public String updateStudent(@ModelAttribute StudentUpdateDto student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long idStudent) {
        studentService.deleteStudent(idStudent);
        return "redirect:/students";
    }
}