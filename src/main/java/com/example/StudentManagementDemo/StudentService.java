package com.example.StudentManagementDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {

    @Autowired
    StudentRepo stdRepo =new StudentRepo();


        public String addStudent(Student student) {
            return stdRepo.addStudent(student);
        }

    public Student getStudent(int admnNo) {
           return stdRepo.getStudent(admnNo);
    }
    public String studentByAdmnNo(int id,String msg){

            Student s=stdRepo.studentByAdmnNo(id);
            if(s==null){
                return null;
            }
            return s+msg;
    }

    public String deleteStudent(int admnNo) {
           return  stdRepo.deleteStudent(admnNo);
    }

    public String update(int admnNo, String course) {
            return stdRepo.update(admnNo,course);
    }

    public int getByAge(int age) {
            return stdRepo.getByAge(age);
    }

    public String getByAgeName(int age) {
            return stdRepo.getByAgeName(age);
    }
}
