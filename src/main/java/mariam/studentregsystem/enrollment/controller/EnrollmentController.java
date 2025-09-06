package mariam.studentregsystem.enrollment.controller;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.enrollment.model.Enrollment;
import mariam.studentregsystem.enrollment.model.EnrollmentRequest;
import mariam.studentregsystem.enrollment.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll")
    private ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentRequest request){
        return new ResponseEntity<>(enrollmentService.enrollStudent(request), HttpStatus.OK);
    }
}
