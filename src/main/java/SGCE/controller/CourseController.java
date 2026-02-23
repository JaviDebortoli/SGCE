package SGCE.controller;

import SGCE.dto.course.CourseCreateDto;
import SGCE.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courseCreateDto", new CourseCreateDto());
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/courses";
    }

    @PostMapping
    public String saveCourse(@Valid @ModelAttribute("courseCreateDto") CourseCreateDto courseCreateDto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "courses/courses";
        }

        courseService.createCourse(courseCreateDto);
        return "redirect:/courses";
    }

    @PostMapping("/delete")
    public String deleteCourse(@RequestParam Long idCourse) {
        courseService.deleteCourse(idCourse);
        return "redirect:/courses";
    }
}