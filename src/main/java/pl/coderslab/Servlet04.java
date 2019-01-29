package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] coockies = request.getCookies();
        int numberOfVisits = 0;

        for (Cookie cookie: coockies
             ) {
            if (cookie.getName().equals("visits")){
                numberOfVisits = Integer.parseInt(cookie.getValue());
                cookie.setValue(String.valueOf(++numberOfVisits));
                response.addCookie(cookie);
                response.getWriter().append("Witaj, odwiedziłeś nas już ").append(String.valueOf(numberOfVisits)).append(" razy.");
            }
        }

        if (numberOfVisits == 0){
            Cookie cookie = new Cookie("visits", String.valueOf(++numberOfVisits));
            cookie.setMaxAge(24 * 60 * 60 * 365);
            response.addCookie(cookie);
            response.getWriter().append("Witaj pierwszy raz na mojej stronie!").append("<br>");
        }
    }
}
