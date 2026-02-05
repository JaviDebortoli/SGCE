package SGCE.controller;

import SGCE.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping()
    public String showEnrollmentForm() {
        enrollmentService.getAllEnrollments();
        return "enrollments/enrollments";
    }

    @PostMapping
    public String enrollStudent(@RequestParam Long idStudent, @RequestParam Long idCourse) {
        enrollmentService.enrollStudent(idStudent, idCourse);
        return "redirect:/enrollments";
    }
}