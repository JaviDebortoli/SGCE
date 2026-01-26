package SGCE.controller;

import SGCE.service.CourseService;
import SGCE.service.EnrollmentService;
import SGCE.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping("/new")
    public String showEnrollmentForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());
        return "enrollments/form";
    }

    @PostMapping
    public String enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
        return "redirect:/students";
    }
}