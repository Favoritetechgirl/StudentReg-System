package mariam.studentregsystem.student.controller;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.student.model.Student;
import mariam.studentregsystem.student.model.StudentRequest;
import mariam.studentregsystem.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    private ResponseEntity<Student> createStudent(@RequestBody StudentRequest request){
        return new ResponseEntity<>(studentService.createStudent(request), HttpStatus.CREATED);
    }
    @GetMapping("/get/{name}")
    private ResponseEntity<Optional<Student>> getStudentByFirstName(@PathVariable String name){
        return new ResponseEntity<>(studentService.getStudentByFirstName(name), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }
    @PutMapping("/update")
    private ResponseEntity<Student> updateStudent(@RequestBody StudentRequest request, @RequestParam String name){
        return new ResponseEntity<>(studentService.updateStudent(request, name), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{name}")
    private ResponseEntity<Void> deleteStudent(@PathVariable String name){
        studentService.deleteStudent(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
