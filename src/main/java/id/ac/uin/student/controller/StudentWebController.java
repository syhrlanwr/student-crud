package id.ac.uin.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import id.ac.uin.student.entity.Student;
import id.ac.uin.student.service.StudentService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentWebController {
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping("/create")
    public String addStudent(Model model, Student student) {
        model.addAttribute("student", studentService.save(student));
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", studentService.findById(id).get());
        return "formStudent";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

}
