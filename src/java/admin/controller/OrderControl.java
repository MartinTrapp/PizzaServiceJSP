// Controller um Bestellung abzuschließen

package admin.controller;

import admin.model.OrderModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderControl extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
          try{
                OrderModel model = new OrderModel();

                String finish = req.getParameter("finish");

                if(finish != null){
                   model.finishOrder(Integer.parseInt(finish));
                }
                RequestDispatcher view = req.getRequestDispatcher("index.jsp");
                view.forward(req, res);   
          }catch(Exception e){}
       }
}