package com.bjpowernode.controller;

import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {
    /**
     * @DubboReference 引用远程服务，把创建好的代理对象，注入给studentService
     * 没有使用interfaceClass，默认的就是引用类型的数据类型
     */
    //@DubboReference(interfaceClass = StudentService.class,version = "2.0")
    @DubboReference(version = "2.0")
    private StudentService studentService;
    @GetMapping("/query")
    public String queryStudent(Integer id){
        Student student = studentService.queryStudent(1001);
        return "调用远程接口，获取对象：" + student;
    }
}
