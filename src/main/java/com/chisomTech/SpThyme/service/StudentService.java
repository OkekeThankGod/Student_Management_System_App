package com.chisomTech.SpThyme.service;

import java.util.List;

import com.chisomTech.SpThyme.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void saveStudent(Student student);
    void deleteStudentById(int id);
}
