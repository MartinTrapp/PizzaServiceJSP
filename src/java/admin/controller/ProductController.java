// Controller zum anlegen, editieren und löschen eines Produktes

package admin.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import admin.model.ProductModel;
import admin.beans.Product;

public class ProductController extends HttpServlet
{
    //löschen
    public void doGet(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
          try{
                res.setContentType("text/html");

                ProductModel model = new ProductModel();
                String page = "products.jsp";
                String del = req.getParameter("del");
                //löschen
                if(del != null){
                   int n = Integer.parseInt(del);
                   model.deleteProduct(n);
                }
               
                String id = req.getParameter("pID");
                String size = "";
                if(id != null){
                  size = model.getSizesString(Integer.parseInt(id));
                  page = "editProduct.jsp?ID="+ id;
                }
                // sprung auf festgelegte Seite
                req.setAttribute("size", size);
                RequestDispatcher view = req.getRequestDispatcher(page);
                view.forward(req, res);   
          }catch(Exception e){}
       }
    //einfügen, editieren
    public void doPost(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
           try{
                res.setContentType("text/html");

                ProductModel model = new ProductModel();
                Product product = new Product();

                product.setName(req.getParameter("name"));
                product.setCategory(Integer.parseInt(req.getParameter("cat")));
                product.setExtras(req.getParameter("extras"));
                product.setSize(req.getParameter("size"));
                
                //einfügen
                if(req.getParameter("add") != null){
                  model.addProduct(product); 
                }
                //editieren
                if(req.getParameter("edit") != null){
                   product.setId(Integer.parseInt(req.getParameter("ID"))); 
                   model.editProduct(product); 
                }
                // Sprung auf festgelegte Seite
                RequestDispatcher view = req.getRequestDispatcher("products.jsp");
                view.forward(req, res);
           }
           catch(Exception e){}
       }
}