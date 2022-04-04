package com.bjpowernode.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController {
   /* public String doJsp(HttpServletRequest request){

        //把数据放到了request作用域
        request.setAttribute("data","SpringBoot使用Jsp");
        //视图的逻辑名称
        return "index";
    }*/

   @RequestMapping("/myjsp")

    public String doJsp(Model model) {

        model.addAttribute("data", "SpringBoot使用Jsp");
        //视图的逻辑名称
        return "index";
    }
}
