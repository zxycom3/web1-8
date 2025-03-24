import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@author 
@Date   2025/3/23 11:13
@description
*/
@WebServlet("/stu")
public class studentserver extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("成功");
        List<student> students = new ArrayList<>();
        students.add(new student("张辉",12,"男"));
        students.add(new student("张话",15,"男"));
        students.add(new student("张明",17,"男"));
        students.add(new student("张化",22,"男"));
        students.add(new student("张宁",21,"男"));
        req.setAttribute("students",students);
        req.getRequestDispatcher("/student.jsp").forward(req, resp);
    }
}
