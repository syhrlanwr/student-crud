package id.ac.uin.student.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.uin.student.entity.Student;
import id.ac.uin.student.exception.StudentNotFoundException;
import id.ac.uin.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id){
        return studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student student){
        Student std = studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        std.setFirstName(student.getFirstName());
        std.setLastName(student.getLastName());
        std.setEmail(student.getEmail());
        std.setPhone(student.getPhone());
        return studentService.save(std);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id){
        Student std = studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        studentService.deleteById(std.getId());
        return "Student with id " + id + " deleted";
    }
}
