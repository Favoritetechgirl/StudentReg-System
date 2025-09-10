package mariam.studentregsystem.course.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import mariam.studentregsystem.enrollment.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String courseName;
    @Column(unique = true)
    private String courseCode;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, String courseCode, List<Enrollment> enrollments) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrollments = enrollments;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
