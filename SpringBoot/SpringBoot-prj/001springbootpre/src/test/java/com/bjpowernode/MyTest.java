package com.bjpowernode;

import com.bjpowernode.config.SpringConfig;
import com.bjpowernode.vo.Cat;
import com.bjpowernode.vo.Student;
import com.bjpowernode.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /*
        使用xml作为容器配置文件
    */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student stu = context.getBean("myStudent",Student.class);
        System.out.println(stu);

    }

    /**
     * 使用JavaConfig方式
     */
    @Test
    public void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student1 = context.getBean("createStudent",Student.class);
        System.out.println(student1);

        Student student2 = context.getBean("s1",Student.class);
        System.out.println(student2);
    }

    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat = context.getBean("myCat",Cat.class);
        System.out.println(cat);
    }

    @Test
    public void test04(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = context.getBean("tiger", Tiger.class);
        System.out.println(tiger);
    }
}
