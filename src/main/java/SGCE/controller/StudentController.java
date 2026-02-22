package SGCE.controller;

import SGCE.dto.student.StudentCreateDto;
import SGCE.dto.student.StudentUpdateDto;
import SGCE.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("studentCreateDto", new StudentCreateDto());
        model.addAttribute("students", studentService.getAllStudents());
        return "students/students";
    }

    @PostMapping
    public String saveStudent(@Valid @ModelAttribute("studentCreateDto") StudentCreateDto studentCreateDto,
                              BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("students", studentService.getAllStudents());
            return "students/students";
        }

        studentService.createStudent(studentCreateDto);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("idStudent", id);
        return "students/students-update";
    }

    @PostMapping("/{id}/edit")
    public String updateStudent(@PathVariable Long id, @ModelAttribute StudentUpdateDto studentUpdateDto) {
        studentService.updateStudent(id, studentUpdateDto);
        return "redirect:/students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long idStudent) {
        studentService.deleteStudent(idStudent);
        return "redirect:/students";
    }
}