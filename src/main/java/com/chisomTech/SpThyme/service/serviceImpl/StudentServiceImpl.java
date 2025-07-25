package com.chisomTech.SpThyme.service.serviceImpl;


import com.chisomTech.SpThyme.entity.Student;
import com.chisomTech.SpThyme.exception.ResourceNotFoundException;
import com.chisomTech.SpThyme.repo.StudentRepo;
import com.chisomTech.SpThyme.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()) {
        	student.get();
        }
        else {
        	throw new ResourceNotFoundException("Student", "id", id);
        }
        return null;
        
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
    }
}
