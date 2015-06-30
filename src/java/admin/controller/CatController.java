// Controller zum einfügen, editieren und löschen von Kategorien
package admin.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import admin.model.CatModel;

// löschen
public class CatController extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
           try{
                CatModel model = new CatModel();

                String del = req.getParameter("del");

                if(del != null){
                   model.deleteCat(Integer.parseInt(del));
                }
                // wenn löschen abgeschlossen, sprung zurück zur Kategorieübersicht    
                RequestDispatcher view = req.getRequestDispatcher("category.jsp");
                view.forward(req, res); 
           }
           catch(Exception e){}
       }
 // einfügen, editieren   
    public void doPost(HttpServletRequest req, HttpServletResponse res)
       throws ServletException, IOException
       {
           try{
                res.setContentType("text/html");

                CatModel model = new CatModel();

                String name = req.getParameter("name");
                int seqNr = Integer.parseInt(req.getParameter("seqNr"));
                
                //einfügen
                if(req.getParameter("add") != null){
                  model.addCat(name, seqNr); 
                }
                //editieren
                if(req.getParameter("edit") != null){
                   int id = Integer.parseInt(req.getParameter("ID")); 
                   model.editCat(id, name, seqNr); 
                }
                // wenn editieren / einfügen sprung zurück zur Kategorieübersicht
                RequestDispatcher view = req.getRequestDispatcher("category.jsp");
                view.forward(req, res);
           }
           catch(Exception e){}
       }
}