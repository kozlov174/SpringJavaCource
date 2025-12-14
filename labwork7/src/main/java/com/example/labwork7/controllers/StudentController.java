package com.example.labwork7.controllers;

import com.example.labwork7.dao.StudentRepository;
import com.example.labwork7.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Slf4j
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping({"/list", "/"})
    public ModelAndView getAllStudents(){
        ModelAndView nav = new ModelAndView("list-students");
        nav.addObject("students", studentRepository.findAll());
        return nav;
    }

    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm(){
        ModelAndView nav = new ModelAndView("add-student-form");
        Student student = new Student();
        nav.addObject("student", student);
        return nav;
    }

    @PostMapping("/saveStudent")
    public RedirectView saveStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return new RedirectView("list");
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long studentId){
        ModelAndView nav = new ModelAndView("add-student-form");
        Optional<Student> optionalStudent = studentRepository.findById(Math.toIntExact(studentId));
        Student student = new Student();
        if(optionalStudent.isPresent()) {
            student = optionalStudent.get();
        }
        nav.addObject("student", student);
        return nav;
    }

    @GetMapping("/deleteStudent")
    public RedirectView deleteStudent(@RequestParam Long studentId){
        studentRepository.deleteById(Math.toIntExact(studentId));
        return new RedirectView("list");
    }
}