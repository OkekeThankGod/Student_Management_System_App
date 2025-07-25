package com.chisomTech.SpThyme.controller;

import com.chisomTech.SpThyme.entity.Student;
import com.chisomTech.SpThyme.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Show all students in the database
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // Show form to add new student
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    // Show form to edit student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        System.out.println("Student with the " + id + "updated ");
        return "student_form";
    }

    // Save student (add or update)
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "student_form";
        }

        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Student saved successfully!");
        return "redirect:/students";
    }


    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
