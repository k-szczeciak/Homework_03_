package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet02")
public class Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String number = request.getParameter("number");
        response.getWriter().append(number).append("<br>");
        int result = 0;
        if (number.matches("^[01]+$")){
            response.getWriter().append("matches").append("<br>");


            int resultAlt = Integer.parseInt(number, 2);
            response.getWriter().append(String.valueOf(resultAlt)).append("<br>");

            char[] numberCharArr = number.toCharArray();
            for (int i = 0; i < numberCharArr.length; i++) {
                if ('1' == numberCharArr[numberCharArr.length - i - 1]){
                    result += Math.pow(2, i);
                }
            }
            response.getWriter().append(String.valueOf(result)).append("<br>");
        }else {
            response.getWriter().append("not matches").append("<br>");

        }
    }

}
