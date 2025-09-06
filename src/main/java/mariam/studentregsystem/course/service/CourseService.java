package mariam.studentregsystem.course.service;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.course.model.Course;
import mariam.studentregsystem.course.model.CourseRequest;
import mariam.studentregsystem.course.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(CourseRequest request) {
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setCourseCode(request.getCourseCode());
        return courseRepository.save(course);
    }

    public Optional<Course> getByCourseName(String name) {
        return Optional.ofNullable(courseRepository.findByCourseName(name));
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course updateCourse(CourseRequest request, String name) {
        Course course = courseRepository.findByCourseName(name);
        course.setCourseName(request.getCourseName());
        course.setCourseCode(request.getCourseCode());
        return courseRepository.save(course);
    }

    public void deleteCourse(String name) {
        Course course = courseRepository.findByCourseName(name);
        courseRepository.delete(course);
    }
}
