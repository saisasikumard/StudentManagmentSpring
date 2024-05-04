package com.example.StudentManagementDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class StudentController {

    @Autowired
    StudentService stdService=new StudentService();

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s=  stdService.addStudent(student);
        if(s==null){
            return new ResponseEntity("Already presented",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(s, HttpStatus.CREATED);

    }

    @GetMapping("/fetch")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
        Student s= stdService.getStudent(admnNo);
        if(s==null){
            return new ResponseEntity("Not have student",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }
    @GetMapping("/fetch_by_num/{id}/{message}")
    public ResponseEntity studentByAdmnNo(@PathVariable("id") int admnNo,@PathVariable("message") String msg){
        String s=stdService.studentByAdmnNo(admnNo,msg);
        if(s==null){
            return new ResponseEntity("Not have student",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int admnNo){
        String s= stdService.deleteStudent(admnNo);
        if(s==null){
            return new ResponseEntity("not have Student",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{id}/{course}")
    public ResponseEntity  update(@PathVariable("id") int admnNo,@PathVariable("course")String course){
        String s= stdService.update(admnNo,course);
        if(s==null){
            return new ResponseEntity("No Student with admission Number to update",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }
    @GetMapping("/AgedStudents")
    public ResponseEntity getByage(@RequestParam("age") int age)
    {
        int s=stdService.getByAge(age);
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }

    @GetMapping("/AgedStudentsName")
    public ResponseEntity getByAgeName(@RequestParam("age") int age)
    {
       String s= stdService.getByAgeName(age);
       if(s==null){
           return new ResponseEntity("No students are there",HttpStatus.BAD_REQUEST);

    }
       return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }
}
