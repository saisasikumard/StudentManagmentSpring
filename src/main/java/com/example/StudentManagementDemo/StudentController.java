package com.example.StudentManagementDemo;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String  addStudent(@RequestBody Student student){
        return  stdService.addStudent(student);

    }

    @GetMapping("/fetch")
    public Student getStudent(@RequestParam("id") int admnNo){
        return stdService.getStudent(admnNo);
    }
    @GetMapping("/fetch_by_num/{id}/{message}")
    public String studentByAdmnNo(@PathVariable("id") int admnNo,@PathVariable("message") String msg){
        return stdService.studentByAdmnNo(admnNo,msg);
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admnNo){
        return stdService.deleteStudent(admnNo);
    }

    @PutMapping("/update/{id}/{course}")
    public String update(@PathVariable("id") int admnNo,@PathVariable("course")String course){
       return stdService.update(admnNo,course);
    }
    @GetMapping("/AgedStudents")
    public int getByage(@RequestParam("age") int age)
    {
       return  stdService.getByAge(age);
    }

    @GetMapping("/AgedStudentsName")
    public String getByAgeName(@RequestParam("age") int age)
    {
       return stdService.getByAgeName(age);
    }
}
