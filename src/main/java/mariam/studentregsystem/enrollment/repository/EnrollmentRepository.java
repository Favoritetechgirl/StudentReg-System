package mariam.studentregsystem.enrollment.repository;

import mariam.studentregsystem.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
