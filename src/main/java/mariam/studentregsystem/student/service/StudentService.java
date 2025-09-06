package mariam.studentregsystem.student.service;

import lombok.RequiredArgsConstructor;
import mariam.studentregsystem.student.model.Student;
import mariam.studentregsystem.student.model.StudentRequest;
import mariam.studentregsystem.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentRequest request){
    Student student = new Student();
    student.setFirstName(request.getFirstName());
    student.setLastName(request.getLastName());
    student.setEmail(request.getEmail());
    String studentId = "STU-" + (new Random().nextInt(2025) + 10);
        student.setStudentId(studentId);
        return studentRepository.save(student);
    }
    public Optional<Student> getStudentByFirstName(String name){
    return Optional.ofNullable(studentRepository.findStudentByFirstName(name));
    }
    public List<Student> getAll(){
    return studentRepository.findAll();
    }
    public Student updateStudent(StudentRequest request, String name){
    Student student = studentRepository.findStudentByFirstName(name);
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        return studentRepository.save(student);
    }
public void deleteStudent(String name){
    Student student = studentRepository.findStudentByFirstName(name);
    studentRepository.delete(student);
}
}
