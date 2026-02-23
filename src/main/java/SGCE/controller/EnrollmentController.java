package SGCE.controller;

import SGCE.domain.EnrollmentStatus;
import SGCE.dto.enrollment.EnrollmentCreateDto;
import SGCE.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping()
    public String listEnrollments(Model model) {
        model.addAttribute("enrollmentCreateDto", new EnrollmentCreateDto());
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
        return "enrollments/enrollments";
    }

    @PostMapping
    public String enrollStudent(
            @Valid @ModelAttribute("enrollmentCreateDto") EnrollmentCreateDto enrollmentCreateDto,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
            return "enrollments/enrollments";
        }

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