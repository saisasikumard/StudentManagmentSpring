package com.example.StudentManagementDemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> StudentDB=new HashMap<>();

    @PostMapping("/add")
    public String  addStudent(@RequestBody Student student){
        StudentDB.put(student.getAdmnNo(),student);
        return "Student added Successfully";
    }

    @GetMapping("/fetch")
    public Student getStudent(@RequestParam("id") int admnNo){
        return StudentDB.get(admnNo);
    }
    @GetMapping("/fetch_by_num/{id}/{message}")
    public String studentByAdmnNo(@PathVariable("id") int admnNo,@PathVariable("message") String msg){
        return StudentDB.get(admnNo)+msg;
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admnNo){
        StudentDB.remove(admnNo);
        return "Deleted successfully";
    }

    @PutMapping("/update/{id}/{course}")
    public String update(@PathVariable("id") int admnNo,@PathVariable("course")String course){
        Student s=StudentDB.get(admnNo);
        s.setCourse(course);
        return "Successufully you changed the course!! ";
    }
    @GetMapping("/AgedStudents")
    public int getByage(@RequestParam("age") int age)
    {
        int num=0;
        for(Map.Entry<Integer,Student> SMap:StudentDB.entrySet()){
            if(SMap.getValue().getAge()>age){
                num++;
            }
        }
        return num;
    }

    @GetMapping("/AgedStudentsName")
    public String getByageName(@RequestParam("age") int age)
    {
        List<String> std=new ArrayList<>();
        for(Map.Entry<Integer,Student> SMap:StudentDB.entrySet()){
            if(SMap.getValue().getAge()>age){
                std.add(SMap.getValue().getName());
            }
        }
        return std.toString();
    }
}
