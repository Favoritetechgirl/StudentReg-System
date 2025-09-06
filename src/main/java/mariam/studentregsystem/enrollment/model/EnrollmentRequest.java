package mariam.studentregsystem.enrollment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class EnrollmentRequest {
    private String studentId;
    private String courseCode;
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
