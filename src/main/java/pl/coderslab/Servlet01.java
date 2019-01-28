package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String amount = request.getParameter("amount");
        double amountDouble = 0;
        double eur_usd = 1.1427;
        double usd_eur = 1/eur_usd;
        double eur_pln = 4.2885;
        double pln_eur = 1/eur_pln;
        double usd_pln = 3.7592;
        double pln_usd = 1/usd_pln;
        String curPair = request.getParameter("curPair");

        try{
            amountDouble = Double.parseDouble(amount);
        }catch (NumberFormatException e){
            response.getWriter().append("niewaciwa wartość").append("<br>");
        }
        if (curPair == null){
            response.getWriter().append("brak wyboru pary walut").append("<br>");
        }else{
            switch (curPair){
                case "EUR_USD":{
                    double result = amountDouble * eur_usd;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" USD").append("<br>");
                    break;
                }
                case "USD_EUR":{
                    double result = amountDouble * usd_eur;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" EUR").append("<br>");
                    break;
                }
                case "EUR_PLN":{
                    double result = amountDouble * eur_pln;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" PLN").append("<br>");
                    break;
                }
                case "PLN_EUR":{
                    double result = amountDouble * pln_eur;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" EUR").append("<br>");
                    break;
                }
                case "USD_PLN":{
                    double result = amountDouble * usd_pln;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" PLN").append("<br>");
                    break;
                }
                case "PLN_USD":{
                    double result = amountDouble * pln_usd;
                    response.getWriter().append("Stan na dzień 2019.01.28:").append("<br>");
                    response.getWriter().append(String.format( "%.2f", result )).append(" USD").append("<br>");
                    break;
                }
                default:response.getWriter().append("niewaciwa wartość");
            }
        }
        //response.getWriter().append(String.valueOf(result)).append("<br>");



        //response.getWriter().append("amount: ").append(amount).append(", ").append(curPair);






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

    }
}
