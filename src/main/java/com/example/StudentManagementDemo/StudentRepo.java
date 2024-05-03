package com.example.StudentManagementDemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo
{
    Map<Integer,Student> StudentDB=new HashMap<>();

    public  String deleteStudent(int admnNo) {
        if(!StudentDB.containsKey(admnNo)){
            return "No Student is there by admission Number!!";
        }
        StudentDB.remove(admnNo);
        return "Student removed Succesfully";
    }

    public String addStudent(Student student) {
        if(StudentDB.containsKey(student.getAdmnNo())){
            return "Already admitted Student";
        }
        StudentDB.put(student.getAdmnNo(),student);
        return "Successfully added!!";
    }

    public Student getStudent(int admnNo) {
        return StudentDB.get(admnNo);
    }

    public Student studentByAdmnNo(int id) {


        return StudentDB.get(id);
    }

    public String update(int admnNo, String course) {
        if(StudentDB.containsKey(admnNo)){
            Student s=StudentDB.get(admnNo);
            s.setCourse(course);
            return s.toString();
        }
        return "No Student with admission Number to update";

    }

    public int getByAge(int age) {
        int num=0;
//        for(Map.Entry<Integer,Student> SMap:StudentDB.entrySet())
//        {
//            if(SMap.getValue().getAge()>age)
//            {
//                num++;
//            }
//        }
        for (int key:StudentDB.keySet()){
            if(StudentDB.get(key).getAge()>age){
                num++;
            }
        }
        return num;
    }

    public String getByAgeName(int age) {
        List<String> std=new ArrayList<>();
        for(Map.Entry<Integer,Student> SMap:StudentDB.entrySet()){
            if(SMap.getValue().getAge()>age){
                std.add(SMap.getValue().getName());
            }
        }
        return std.toString();
    }
}
