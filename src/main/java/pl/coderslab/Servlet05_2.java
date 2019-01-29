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

@WebServlet("/Servlet05_2")
public class Servlet05_2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession sess = request.getSession();
        double prodValue = 0;
        double sum = 0;

        List<Basket> basketList = (ArrayList<Basket>)sess.getAttribute("basket");


        for (int i = 0; i < basketList.size(); i++) {
            prodValue = (double)basketList.get(i).getQty() * basketList.get(i).getPrice();
            sum += prodValue;
            response.getWriter().append(basketList.get(i).getItem()).append(" - ")
                    .append(String.valueOf(basketList.get(i).getQty())).append(" x ")
                    .append(String.format( "%.2f", basketList.get(i).getPrice() )).append("zł")
                    .append(" = ").append(String.format( "%.2f", prodValue )).append("<br>");
        }
        response.getWriter().append("suma: ").append(String.format( "%.2f", sum ));
    }
}
