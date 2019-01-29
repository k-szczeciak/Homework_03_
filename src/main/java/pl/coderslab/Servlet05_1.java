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

@WebServlet("/Servlet05_1")
public class Servlet05_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String item = request.getParameter("item");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        //response.getWriter().append(item).append(", ").append(qty).append(", ").append(price);

        int qtyInt = Integer.parseInt(qty);
        double priceDouble = Double.parseDouble(price);

        List<Basket> basketList;

        HttpSession sess = request.getSession();
        if (sess.getAttribute("basket") == null){
            basketList = new ArrayList<Basket>();
        }else{
            basketList = (ArrayList<Basket>)sess.getAttribute("basket");
        }
        Basket basket = new Basket(item, qtyInt, priceDouble);
        basketList.add(basket);
        sess.setAttribute("basket", basketList);
        response.sendRedirect("/Servlet05_1?newItem=true");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //form for adding products
        response.setContentType("text/html; charset=utf-8");

        String newItem = request.getParameter("newItem");
        if ("true".equals(newItem)){
            response.getWriter().append("Produkt dodany...").append("<br>").append("dodaj następny produkt: ").append("<br><br>");
        }

        response.getWriter().append("<form action='/Servlet05_1' method=\"post\">\n" +
                "        <input type='text' name='item' placeholder='przedmiot'> <br>\n" +
                "        <input type='number' name='qty' placeholder='ilość'> <br>\n" +
                "        <input type='number' name='price' step='0.01' placeholder='cena'> <br>\n" +
                "        <input type='submit' value='DODAJ'>\n" +
                "    </form><br>");
        if ("true".equals(newItem)){
            response.getWriter().append("<a href='/Servlet05_2'>Pokaż koszyk </a>");
        }
    }
}
