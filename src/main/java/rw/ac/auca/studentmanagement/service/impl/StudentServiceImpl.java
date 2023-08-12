package rw.ac.auca.studentmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rw.ac.auca.studentmanagement.dao.StudentDao;
import rw.ac.auca.studentmanagement.model.Student;
import rw.ac.auca.studentmanagement.service.StudentService;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student createStudent(Student student) {
        if(student == null || student.getFirstName() == null){
            throw new IllegalArgumentException();
        }

        return studentDao.save(student);
    }

    @Override
    public Student updateStudent(Student updatedStudent, int oldStudentId) {
        return null;
    }

    @Override
    public List<Student> viewStudents() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = studentDao.findById(studentId).orElse(null);
        if(student != null){
            studentDao.delete(student);
        }
    }
}
