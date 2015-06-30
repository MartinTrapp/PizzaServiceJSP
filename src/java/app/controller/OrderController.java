// Controller um Bestellung abzuschließen

package app.controller;

import app.model.OrderModel;
import app.beans.Basket;
import app.beans.Costumer;
import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderController extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
    	  try{
                res.setContentType("text/html");
                RequestDispatcher view;
                
                Costumer cust = new Costumer();
                cust.setTitle(req.getParameter("title"));
                cust.setFirstName(req.getParameter("firstName"));
                cust.setLastName(req.getParameter("lastName"));
                cust.setStreet(req.getParameter("street"));
                cust.setNumber(req.getParameter("number"));
                cust.setTown(req.getParameter("town"));
                cust.setZip(req.getParameter("zip"));
                cust.setTel(req.getParameter("tel"));
                cust.setWish(req.getParameter("wish"));
        
                // Wenn keine fehlerhaften Eingaben vorhanden, Bestellung abschicken
                if(cust.getErrors().isEmpty()){
                    Basket b = (Basket)req.getSession().getAttribute("basket");
                    OrderModel order = new OrderModel();
                    order.newOrder(cust, b);
                    view = req.getRequestDispatcher("orderStatus.jsp");  
                }
                // ansonsten rücksprung zum Formular mit Fehlermeldung
                else{
                    view = req.getRequestDispatcher("order.jsp");
                    req.setAttribute("customer", cust);
                }
                view.forward(req, res);
          }
          catch(Exception e){}  
       }
}