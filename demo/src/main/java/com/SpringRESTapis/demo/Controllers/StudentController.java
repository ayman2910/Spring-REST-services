package com.SpringRESTapis.demo.Controllers;

import com.SpringRESTapis.demo.POJOs.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Hossain","Ayman"));
        students.add(new Student(2,"Suhaila","Obdhi"));
        students.add(new Student(3,"Nigga","Higga"));

        return students;
    }
    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Hossain","Ayman"));
        students.add(new Student(2,"Suhaila","Obdhi"));
        students.add(new Student(3,"Nigga","Higga"));

        return students.get(studentId-1);
    }

}
