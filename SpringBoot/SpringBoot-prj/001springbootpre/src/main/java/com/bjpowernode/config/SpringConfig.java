package com.bjpowernode.config;

import com.bjpowernode.vo.Student;
import org.junit.Test;
import org.springframework.context.annotation.*;

/**
 * @Configuration 表示当前类作为配置文件使用的，就是用来配置容器的
 *  位置：在类的上面
 *  SpringConfig这个类就相当于beans.xml
 *
 */
@Configuration
@ImportResource(value = "classpath:applicationContext.xml")
@PropertySource(value = "classpath:config.properties")
@ComponentScan(basePackages = "com.bjpowernode.vo")
public class SpringConfig {
    /**
     * 创建方法，方法的返回值是对象，在方法的上面加入@Bean
     * 方法的返回值就注入到容器中。
     * 位置：方法的上面
     *
     * @Bean 把对象注入到容器中，就相当于Bean标签;如果不指定对象的名称，默认方法名是 id
     *
     */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setName("张三");
        student.setAge(26);
        student.setSex("男");
        return student;
    }

    /**
     * 指定对象在容器里的名称
     * @Bean的name属性，指定对象的名称(id)
     */
    @Bean(name = "s1")
    public Student createStudent2(){
        Student s1 = new Student();
        s1.setName("王五");
        s1.setAge(20);
        s1.setSex("男");
        return s1;
    }
}
