package SGCE.controller;

import SGCE.dto.enrollment.EnrollmentCreateDto;
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
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping()
    public String listEnrollments(Model model) {
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
        return "enrollments/enrollments";
    }

    @PostMapping
    public String enrollStudent(@ModelAttribute EnrollmentCreateDto enrollmentCreateDto) {
        enrollmentService.createEnrollment(enrollmentCreateDto);
        return "redirect:/enrollments";
    }
}