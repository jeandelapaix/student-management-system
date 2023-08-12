package rw.ac.auca.studentmanagement.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rw.ac.auca.studentmanagement.dao.StudentDao;
import rw.ac.auca.studentmanagement.model.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentDao studentDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateStudentPositiveScenario() {
        Student student = new Student();
        student.setId(89);
        student.setFirstName("Test1");
        student.setLastName("Test2");
        student.setDob(new Date());
        student.setFaculty("IT");
        student.setDepartment("Network");

        when(studentDao.save(student)).thenReturn(student);
        Student createdStudent = studentService.createStudent(student);
        assertNotNull(createdStudent);
        assertEquals(student,createdStudent);
        assertEquals("Test1", createdStudent.getFirstName());
        assertEquals("Test2", createdStudent.getLastName());
    }

    @Test
    public void testCreateStudentWithNull() {
        assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(null));
    }

    @Test
    public void testCreateStudentWithEmptyFirstname() {
        Student student = new Student();
        assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(student));
    }

    @Test
    void updateStudent() {
    }

    @Test
    void viewStudents() {
        List<Student> expectedStudentList = Arrays.asList(
                new Student(1, "Kamana", "Eugene", new Date(), "IT", "Info"),
                new Student(2, "Kamanzi", "Aimable", new Date(), "BA", "finance")
        );
        when(studentDao.findAll()).thenReturn(expectedStudentList);
        List<Student> actualStudentList = studentService.viewStudents();
        assertEquals(expectedStudentList.size(), actualStudentList.size());
    }

    @Test
    void deleteStudent() {
    }
}