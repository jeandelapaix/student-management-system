package rw.ac.auca.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.ac.auca.studentmanagement.model.Student;
import rw.ac.auca.studentmanagement.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    /**
     * @PostManpping: Save
     * @PutMapping: Update
     * @GetMapping: View/Search/....
     * @DeleteMapping: Delete
     * */

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> studentList(){
        return studentService.viewStudents();
    }

}
