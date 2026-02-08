package SGCE.controller;

import SGCE.service.CourseService;
import SGCE.service.EnrollmentService;
import SGCE.service.StudentService;
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
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("enrollments",enrollmentService.getLast5Enrollments());
        model.addAttribute("totalEnrollments", enrollmentService.getEnrollmentCount());
        model.addAttribute("totalStudents",studentService.getStudentCount());
        model.addAttribute("totalCourses",courseService.getCourseCount());
        return "index";
    }
}