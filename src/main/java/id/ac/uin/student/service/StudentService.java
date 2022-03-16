package id.ac.uin.student.service;

import java.util.List;
import java.util.Optional;

import id.ac.uin.student.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> findById(Long id);
    Optional<Student> findByEmail(String email);
    Student save(Student student);
    void deleteById(Long id);
}
