package mariam.studentregsystem.student.repository;

import mariam.studentregsystem.enrollment.model.Enrollment;
import mariam.studentregsystem.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByFirstName(String name);
    Optional<Student> findByStudentId(String studentId);
}
