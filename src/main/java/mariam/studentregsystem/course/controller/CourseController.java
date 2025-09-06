package mariam.studentregsystem.course.controller;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.course.model.Course;
import mariam.studentregsystem.course.model.CourseRequest;
import mariam.studentregsystem.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    private ResponseEntity<Course> createCourse(@RequestBody CourseRequest request) {
        return new ResponseEntity<>(courseService.createCourse(request), HttpStatus.CREATED);
    }

    @GetMapping("/get/{name}")
    private ResponseEntity<Optional<Course>> getByCourseName(@PathVariable String name) {
        return new ResponseEntity<>(courseService.getByCourseName(name), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<Course> updateCourse(@RequestBody CourseRequest request, @RequestParam String name) {
        return new ResponseEntity<>(courseService.updateCourse(request, name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    private ResponseEntity<Void> deleteCourse(@PathVariable String name) {
        courseService.deleteCourse(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
