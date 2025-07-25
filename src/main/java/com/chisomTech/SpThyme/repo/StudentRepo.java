package com.chisomTech.SpThyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chisomTech.SpThyme.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
