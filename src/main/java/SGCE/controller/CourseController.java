package SGCE.controller;

import SGCE.domain.Course;
import SGCE.dto.CourseDto;
import SGCE.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/courses";
    }

    @GetMapping("/new")
    public String formCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses/courses-form";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute CourseDto course) {
        courseService.createCourse(course);
        return "redirect:/courses";
    }
}