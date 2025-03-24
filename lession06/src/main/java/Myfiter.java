import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/*
@author 
@Date   2025/3/23 09:04
@description
*/
@WebFilter({"/student.jsp","/stu"})
//@WebFilter("/*")
public class Myfiter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("Myfiter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
       HttpServletRequest se=(HttpServletRequest) servletRequest;
       String username=(String)se.getSession().getAttribute("username");
       if(username!=null)
       {
           filterChain.doFilter(servletRequest, servletResponse);
       }
       else
       {
           servletRequest.setAttribute("msg","请登录");
           servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
       }
    }

    @Override
    public void destroy()
    {
        System.out.println("Myfiter destroy");
    }
}
