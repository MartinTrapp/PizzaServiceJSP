//Controller zum hinzufügen, abziehen, löschen eines Produktes aus dem Einkaufskorb 

package app.controller;

import app.model.BasketModel;
import app.beans.Basket;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class BasketController extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
    	  try{
                // Einkaufskorb aus der Session holen
                Basket b = (Basket)req.getSession().getAttribute("basket");
                BasketModel model = new BasketModel();
                String add = req.getParameter("add");
                String sub= req.getParameter("sub");
                String del = req.getParameter("del");
                String jumpBack = req.getParameter("cat");
                if(jumpBack.equals("")){
                    jumpBack = "1";
                }
                
                // produkt hinzufügen
                if(add != null){
                   int n = Integer.parseInt(add);
                   model.addBean(n, b);
                }
                
                //produkt abziehen
                if(sub != null){
                   int n = Integer.parseInt(sub);
                   model.subBean(n, b);
                }
                
                //produkt löschen
                if(del != null){
                   int n = Integer.parseInt(del);
                   model.delBean(n, b);
                }

                
                //Sprung zur letzten Kategorie von der man kam  
                RequestDispatcher view = req.getRequestDispatcher("products.jsp?cat=" + jumpBack);
                view.forward(req, res);
          }catch(Exception e){}
       }
}