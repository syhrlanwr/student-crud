package id.ac.uin.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "first name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "email is required")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "phone number is required")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phone;
}
