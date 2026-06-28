package com.SpringRESTapis.demo.Controllers;

import com.SpringRESTapis.demo.POJOs.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<Student> students;
    @PostConstruct
    private void loadData(){
        students = new ArrayList<>();

        students.add(new Student(1,"Hossain","Ayman"));
        students.add(new Student(2,"Suhaila","Obdhi"));
        students.add(new Student(3,"Nigga","Higga"));

        System.out.println("Loading Data");

    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId <1 || studentId > students.size()){
            throw new StudentExceptionHandler("Student Id not found - "+studentId);
        }
        return students.get(studentId-1);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentExceptionHandler exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
