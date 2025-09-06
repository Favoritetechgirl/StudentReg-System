package mariam.studentregsystem.student.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mariam.studentregsystem.enrollment.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String studentId;
    private String lastName;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String firstName,String studentId, String lastName, String email, List<Enrollment> enrollments) {
        this.id = id;
        this.firstName = firstName;
        this.studentId = studentId;
        this.lastName = lastName;
        this.email = email;
        this.enrollments = enrollments;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
