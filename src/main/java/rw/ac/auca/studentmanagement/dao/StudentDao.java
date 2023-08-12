package rw.ac.auca.studentmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.auca.studentmanagement.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}
