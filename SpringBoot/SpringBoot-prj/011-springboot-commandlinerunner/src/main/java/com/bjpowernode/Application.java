package com.bjpowernode;

import com.bjpowernode.service.HelloService;
import com.bjpowernode.service.HelloServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private HelloService helloService;

    public static void main(String[] args) {

        System.out.println("准备创建容器对象");
        //创建容器对象
        SpringApplication.run(Application.class, args);
        System.out.println("容器对象创建之后");

    }

    @Override
    public void run(String... args) throws Exception {

        String str = helloService.sayHello("张三");
        System.out.println("调用容器中的对象=" + str);

        //可做自定义的操作，比如读取文件，数据库等等
        System.out.println("在容器对象创建好后，执行的方法");
    }

    /*
    准备创建容器对象
    调用容器中的对象=你好张三
    在容器对象创建好后，执行的方法
    容器对象创建之后
    */
}
