package mariam.studentregsystem.course.repository;

import mariam.studentregsystem.course.model.Course;
import mariam.studentregsystem.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
 Course findByCourseName(String name);
 Optional<Course> findByCourseCode(String courseCode);
}
