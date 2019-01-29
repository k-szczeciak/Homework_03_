package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet06")
public class Servlet06 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String num3 = request.getParameter("num3");
        String num4 = request.getParameter("num4");

        int num1Int = Integer.parseInt(num1);
        int num2Int = Integer.parseInt(num2);
        int num3Int = Integer.parseInt(num3);
        int num4Int = Integer.parseInt(num4);

        double sum = (double)(num1Int + num2Int + num3Int + num4Int);
        double average = (sum / 4);
        double product = (double)(num1Int * num2Int * num3Int * num4Int);

        response.getWriter().append("Liczby:").append("<br>")
                .append(" - ").append(num1).append("<br>")
                .append(" - ").append(num2).append("<br>")
                .append(" - ").append(num3).append("<br>")
                .append(" - ").append(num4).append("<br>")
                .append("<br>")
                .append("Średnia:").append("<br>")
                .append(" - ").append(String.valueOf(average)).append("<br>").append("<br>")
                .append("Suma:").append("<br>")
                .append(" - ").append(String.valueOf(sum)).append("<br>").append("<br>")
                .append("Iloczyn:").append("<br>")
                .append(" - ").append(String.valueOf(product)).append("<br>");

    }
}
