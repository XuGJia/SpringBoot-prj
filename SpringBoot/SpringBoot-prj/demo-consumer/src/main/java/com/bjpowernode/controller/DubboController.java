package com.bjpowernode.controller;

import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DubboController {
    @DubboReference(interfaceClass = StudentService.class,version = "2.0")
    private StudentService studentService;

    @PostMapping("/student/add")
    public String addStudent(Student student){

        //对student数据做处理，name 需要有值，phone，age必须有值
        int result = studentService.addStudent(student);
        String msg = "请稍后处理";

        if (result == 1){
            msg = "添加学生：" + student.getName() + "成功";
        }else if (result == 2){
            msg = student.getPhone() + "，此手机号重复，请更换手机号";
        }else if (result == 3){
            msg = "手机号为空";
        }

        return "消费者添加学生：" + msg;
    }

    @GetMapping("/student/query")
    public String queryStudent(Integer id){
        String msg ="";
        Student student = null;
        if (id != null && id >0) {
            student = studentService.queryStudent(id);
            if (student != null){
                msg = "查询的学生信息是：" + student.toString();
            }else{
                msg = "没有查询到";
            }
        }else {
            msg = "查询的id不正确";
        }
        return msg;
    }
}
