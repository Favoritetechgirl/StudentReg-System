package mariam.studentregsystem.enrollment.service;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.course.model.Course;
import mariam.studentregsystem.course.repository.CourseRepository;
import mariam.studentregsystem.enrollment.model.Enrollment;
import mariam.studentregsystem.enrollment.model.EnrollmentRequest;
import mariam.studentregsystem.enrollment.repository.EnrollmentRepository;
import mariam.studentregsystem.student.model.Student;
import mariam.studentregsystem.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class EnrollmentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment enrollStudent(EnrollmentRequest request) {
        Student student = studentRepository.findByStudentId(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findByCourseCode(request.getCourseCode())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student.getStudentId());
        enrollment.setCourse(course.getCourseCode());
        enrollment.setEnrollmentDate(LocalDate.now());

        return enrollmentRepository.save(enrollment);
    }
}
