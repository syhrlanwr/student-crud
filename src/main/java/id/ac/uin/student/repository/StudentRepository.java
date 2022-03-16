package id.ac.uin.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.uin.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}