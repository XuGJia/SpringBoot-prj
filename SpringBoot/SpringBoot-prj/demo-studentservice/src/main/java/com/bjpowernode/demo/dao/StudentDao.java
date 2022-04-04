package com.bjpowernode.demo.dao;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    //按手机号作为条件查询
    Student selectByPhone(@Param("phone") String phone);

    //添加数据
    int insertStudent(Student student);

    //按id查询
    Student selectById(@Param("id") Integer id);
}
