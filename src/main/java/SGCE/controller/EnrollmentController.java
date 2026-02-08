package SGCE.controller;

import SGCE.dto.CourseDto;
import SGCE.dto.EnrollmentDto;
import SGCE.service.CourseService;
import SGCE.service.EnrollmentService;
import SGCE.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping()
    public String listEnrollments(Model model) {
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
        return "enrollments/enrollments-list";
    }

    @GetMapping("/new")
    public String newEnrollment() {
        return "enrollments/enrollments";
    }

    @PostMapping
    public String enrollStudent(@RequestParam Long idStudent, @RequestParam Long idCourse) {
        enrollmentService.enrollStudent(idStudent, idCourse);
        return "redirect:/enrollments";
    }
}