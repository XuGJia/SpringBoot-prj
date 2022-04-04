package com.bjpowernode.service;

import com.bjpowernode.model.Student;
//Dubbo接口
public interface StudentService {
    int addStudent(Student student);
    Student queryStudent(Integer id);
}
