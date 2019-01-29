package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet03")
public class Servlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        //response.sendRedirect("doGet");
        // session request
        HttpSession sess = request.getSession();

        // reading values from form
        List<String> dane = new ArrayList<String>();
        for (int i = 1; i < 6; i++) {
            dane.add(request.getParameter("value" + i));
        }
        //show read values from form
        for (String cell: dane
             ) {
            response.getWriter().append(cell).append(", ");
        }
        //reading seesion data if exists
        if (sess.getAttribute("dane")==null){
            sess.setAttribute("dane", dane);
            response.getWriter().append("dane dopisane do sesji...").append("<br>");
        }else{
            dane = (List<String>) sess.getAttribute("dane");
            response.getWriter().append("dane w sesji juz istnieja").append("<br>");
        }
        //display form with current data
        response.getWriter().append("<form action='/Servlet03' method='post'>");
        for (int i = 1; i < 6; i++) {
            response.getWriter().append("<input type='text' name='value" + i + "' placeholder='value" + i + "' value='" + dane.get(i-1) + "'><br>");
        }
        response.getWriter().append("<input type='submit' value='Wyslij'></form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        //display form
        response.getWriter().append("<form action='/Servlet03' method='post'>");
        for (int i = 1; i < 6; i++) {
            response.getWriter().append("<input type='text' name='value" + i + "' placeholder='value" + i + "'><br>");
        }
        response.getWriter().append("<input type='submit' value='Wyslij'></form>");
    }
}
