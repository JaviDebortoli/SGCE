package SGCE.controller;

import SGCE.domain.EnrollmentStatus;
import SGCE.dto.enrollment.EnrollmentCreateDto;
import SGCE.service.EnrollmentService;
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
        return "enrollments/enrollments";
    }

    @PostMapping
    public String enrollStudent(@ModelAttribute EnrollmentCreateDto enrollmentCreateDto) {
        enrollmentService.createEnrollment(enrollmentCreateDto);
        return "redirect:/enrollments";
    }

    @PostMapping("/delete")
    public String deleteEnrollment(@RequestParam Long idEnrollment) {
        enrollmentService.deleteEnrollment(idEnrollment);
        return "redirect:/enrollments";
    }

    @PostMapping("/status")
    public String updateEnrollment(@RequestParam Long idEnrollment, @RequestParam EnrollmentStatus status) {
        enrollmentService.changeEnrollmentStatus(idEnrollment, status);
        return "redirect:/enrollments";
    }
}