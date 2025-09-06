package mariam.studentregsystem.enrollment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mariam.studentregsystem.course.model.Course;
import mariam.studentregsystem.student.model.Student;
import java.time.LocalDate;
@Entity
@Table
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate enrollmentDate;
    @Column(name = "student_id")
    private String student;
    @Column(name = "course_code")
    private String course;

    public Enrollment() {}

    public Enrollment(LocalDate enrollmentDate, String student, String course) {
        this.enrollmentDate = enrollmentDate;
        this.student = student;
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String studentId) {
        this.student = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String courseCode) {
        this.course = courseCode;
    }
}
