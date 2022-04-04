package com.bjpowernode.demo.service.impl;

import com.bjpowernode.demo.dao.StudentDao;
import com.bjpowernode.model.Student;
import com.bjpowernode.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

//暴露Dubbo服务
@DubboService(interfaceClass = StudentService.class,version = "2.0",timeout = 5000)
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Resource
    private RedisTemplate redisTemplate;
    /**
     *
     * @param student
     * @return int
     *      1：添加成功
     *      2：手机号已经存在
     *      3：没有手机号
     */
    @Override
    public int addStudent(Student student) {
        int result = 0;
        //查询手机号是否唯一
        if (student.getPhone() != null) {
            Student stu = studentDao.selectByPhone(student.getPhone());
            if (stu != null){
                result = 2;
            }else {
                result = studentDao.insertStudent(student);
            }
        }else {
            result = 3;
        }
        return result;
    }

    /**
     * 缓存穿透
     */
    @Override
    public Student queryStudent(Integer id) {

        //从redis查询Student，使用Json存储对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //值存为Json
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        final String USER_KEY="STUDENT:";

        Student student = null;

        if (id != null){
            //STUDENT:1001
            String key = USER_KEY + id;
            student = (Student) redisTemplate.opsForValue().get(key);
            System.out.println(id + "，从redis查询数据" + student);
            if (student == null){
                //从mybatis查询
                student =  studentDao.selectById(id);
                System.out.println(id + "，从数据库查询数据" + student);
                if (student != null){
                    //存到redis
                    redisTemplate.opsForValue().set(key,student);
                }else {
                    //数据库查不到，在redis添加一个此id的默认值
                    redisTemplate.opsForValue().set(key,Student.defaultStudent());
                }
            }
        }
        return student;
    }
}
