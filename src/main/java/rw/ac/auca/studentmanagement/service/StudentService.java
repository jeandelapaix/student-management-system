package rw.ac.auca.studentmanagement.service;

import rw.ac.auca.studentmanagement.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student updatedStudent, int oldStudentId);
    List<Student> viewStudents();
    void deleteStudent(int studentId);
}
