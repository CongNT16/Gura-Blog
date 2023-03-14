/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import Models.Categories;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author nguye
 */
public class AboutmeController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO c = new CategoryDAO();
        ArrayList<Categories> listbarCategory = (ArrayList<Categories>) c.getListCategory();
        req.setAttribute("listbarCategory", listbarCategory);

        ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
        req.setAttribute("numberTopic", numberTopic);

        
        req.getRequestDispatcher("aboutme.jsp").forward(req, resp);
    }
    
    
    
}
