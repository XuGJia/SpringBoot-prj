package com.bjpowernode;

import com.bjpowernode.service.UserService;
import com.bjpowernode.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //获取容器对象
        //ConfigurableApplicationContext ctx =  SpringApplication.run(Application.class, args);
        ApplicationContext ctx =  SpringApplication.run(Application.class, args);

        //从容其中获取对象
        UserService userService =  ctx.getBean("userService", UserServiceImpl.class);
        userService.sayHello("李四");
    }
}
