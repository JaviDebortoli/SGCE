package SGCE.controller;

import SGCE.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("enrollments",enrollmentService.getAllEnrollments());
        return "index";
    }
}