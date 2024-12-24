package com.spring.security.controller;


import com.spring.security.entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/csrf")
public class csrfController {

    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    void fetchStudents(){
        studentList.add(new Student(1,"student 1"));
        studentList.add(new Student(2,"student 2"));
        studentList.add(new Student(3,"student 3"));
    }

    @GetMapping("/students")
    public List<Student> getStudentsList() {
        return studentList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/students")
    private Student addStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }

}
