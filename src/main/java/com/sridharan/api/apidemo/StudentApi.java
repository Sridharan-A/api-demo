package com.sridharan.api.apidemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.err;


@RestController
public class StudentApi  {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Map<String, String>> badRequestHandler(Exception ex){
        Map<String, String> error = new HashMap<>();
        error.put("errorMsg", ex.getMessage());
        return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);
    }

    private static List<Student> studentList;

    static {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "red", "eee"));
        studentList.add(new Student(2, "green", "ece"));
        studentList.add(new Student(3, "yellow", "cse"));
    }

    @GetMapping("/say-hi")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }


    @GetMapping("/students/{rollNumber}")
    public Student getStudents(@PathVariable String rollNumber) throws Exception{

        int a = Integer.parseInt(rollNumber);

        System.out.println("Roll Number: " + a);
        a = a - 1;
        if(a>=0 && a < studentList.size()){
            return studentList.get(a);
        } else {
            throw new Exception("Record not found");
        }
    }
}