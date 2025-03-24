package com.examp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; // 添加这行导入
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.getRequestDispatcher("/Login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password= req.getParameter("password");

        if ("root".equals(username) && "123456".equals(password)) {
            // 用户密码正确
            resp.sendRedirect("stu");
            resp.sendRedirect(req.getContextPath() + "/stu");
        } else {
            // 用户名或者密码错误
            req.setAttribute("msg", "用户名或者密码错误");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }
}