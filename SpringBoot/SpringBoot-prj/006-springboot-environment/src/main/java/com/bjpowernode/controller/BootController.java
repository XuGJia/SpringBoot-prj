package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //创建控制器对象
public class BootController {
    @RequestMapping("/hello") //括号里表示地址
    @ResponseBody //将doSome方法的返回值作为数据给浏览器
    public String doSome(){
        return "hello SpringBoot 设置了端口";
    }
}
