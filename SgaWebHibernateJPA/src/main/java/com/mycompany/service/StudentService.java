package com.mycompany.service;

import com.mycompany.dao.StudentDAO;
import com.mycompany.domain.Student;

import java.util.List;

public class StudentService {
  private StudentDAO studentDAO = new StudentDAO();

  public List<Student> listStudents() {
    return studentDAO.list();
  }

  public void saveStudent(Student student) {
    if (student != null) {
      studentDAO.insert(student);
    } else {
      studentDAO.update(student);
    }
  }

  public void deleteStudent(Student student) {
    studentDAO.delete(student);
  }

  public Student findStudent(Student student) {
    return studentDAO.searchStudentId(student);
  }
}
