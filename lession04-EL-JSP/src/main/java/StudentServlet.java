import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet 收到get请求");
        List<Student> studentList = new ArrayList<Student>();

        Student student1 = new Student();
        student1.setId(1);
        student1.setNum(10001);
        student1.setName("zhangyi");

        Student student2 = new Student();
        student2.setId(2);
        student2.setNum(10002);
        student2.setName("zhanger");

        Student student3 = new Student();
        student3.setId(3);
        student3.setNum(10003);
        student3.setName("zhangsan");

        Student student4 = new Student();
        student4.setId(4);
        student4.setNum(10004);
        student4.setName("zhangsi");

        Student student5 = new Student();
        student5.setId(5);
        student5.setNum(10005);
        student5.setName("zhangwu");

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        req.setAttribute("students", studentList);

        req.getRequestDispatcher("student.jsp").forward(req, resp);


    }
}