package com.bjpowernode.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp); //传入请求，传入应答
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用HttpServletResponse输出数据，应答结果
        resp.setContentType("text/html;charset=utf-8"); //设置输出的应用类型
        PrintWriter out = resp.getWriter(); //获取Writer对象
        out.println("执行的是Servlet");
        out.flush();
        out.close();

    }
}
