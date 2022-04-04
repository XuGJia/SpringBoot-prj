package com.bjpowernode.config;

import com.bjpowernode.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebApplicationConfig {
    @Bean
    //定义方法，注册Servlet对象
    public ServletRegistrationBean servletRegistrationBean(){
        /*
        //public ServletRegistrationBean(T servlet, String... urlMappings) 有参数的方法
        //第一个参数是 Servlet对象， 第二个是url地址
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        //访问/myservlet这个地址的话，执行的是MyServlet
        */
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/login","/test"); //可以设置多个地址
        return bean;
    }
}
