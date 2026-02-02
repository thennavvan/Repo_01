package com.hsbc.controller;

import com.hsbc.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController

public class HelloController {
    @GetMapping("/")
    public String sayHelloGet(){
        return "Hello";
    }
    @PostMapping
    public String sayHelloPost(){
        return "Hello - post";
    }
    @GetMapping("/{x}/{y}")
    public String sayHelloName(@PathVariable("x") String name, @PathVariable("y") String tech){
        return "Hello " + name + "," + " and working in " + tech;
    }

    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student);
        return "Saved";
    }
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1001, "Pari", "pari@what.com");
        return student;
    }
}
