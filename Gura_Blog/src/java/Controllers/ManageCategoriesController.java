/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.TopicDAO;
import Models.Categories;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManageCategoriesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("user_login_roleid") == null) {
            resp.sendRedirect("404error.html");
        } else if (session.getAttribute("user_login_roleid").equals("1")) {

            String thread = req.getParameter("thread");
            CategoryDAO c = new CategoryDAO();
            TopicDAO t = new TopicDAO();
            String mess = "";

            if (thread.equals("1")) {
                ArrayList<Categories> listCategory = (ArrayList<Categories>) c.getListCategory();
                req.setAttribute("listCategory", listCategory);

                ArrayList<Categories> numberTopic = (ArrayList<Categories>) c.getNumberTopic();
                req.setAttribute("numberTopic", numberTopic);

                req.setAttribute("thread", thread);
                req.getRequestDispatcher("manage_categories.jsp").forward(req, resp);
            }

            if (thread.equals("2")) {

                req.setAttribute("thread", thread);
                req.getRequestDispatcher("manage_categories.jsp").forward(req, resp);

            }

            if (thread.equals("3")) {
                String idcategorydel = req.getParameter("idcategorydel");

                c.deleteCategoryByCategoryId(idcategorydel);

                resp.sendRedirect("ManageCategoriesController?thread=1");

            }

            if (thread.equals("4")) {
                String idcategoryedit = req.getParameter("idcategoryedit");

                Categories categoryWithCategoryId = c.getCategoryWithCategoryID(idcategoryedit);

                req.setAttribute("category_name", categoryWithCategoryId.getCategory_name());

                req.setAttribute("idcategoryedit", idcategoryedit);
                req.setAttribute("thread", thread);
                req.getRequestDispatcher("manage_categories.jsp").forward(req, resp);

            }

            if (thread.equals("6")) {
                String category_name = req.getParameter("category_name");

                //Tạo 1 id mới
                String category_id = "";

                if (!c.checkCategoryName(category_name)) {

                    while (c.checkCategoryId(category_id) == false) {

                        Random generator = new Random();
                        category_id = String.valueOf(generator.nextInt((999 - 100) + 1) + 100);

                        c.insertCategory(category_id, category_name);
                        break;
                    }

                    resp.sendRedirect("ManageCategoriesController?thread=1");
                } else {
                    mess += "Category đã tồn tại";
                    req.setAttribute("category_name", category_name);
                    req.setAttribute("errname", mess);
                    req.setAttribute("thread", 2);
                    req.getRequestDispatcher("manage_categories.jsp").forward(req, resp);

                }

            }

            if (thread.equals("7")) {
                String category_id = req.getParameter("idcategoryedit");
                String category_name = req.getParameter("category_name");

                if (!c.checkCategoryName(category_name)) {

                    c.updateEditCategory(category_id, category_name);

                    resp.sendRedirect("ManageCategoriesController?thread=1");
                } else {
                    mess += "Category đã tồn tại";
                    req.setAttribute("category_name", category_name);
                    req.setAttribute("errname", mess);
                    req.setAttribute("idcategoryedit", category_id);
                    req.setAttribute("thread", 4);
                    req.getRequestDispatcher("manage_categories.jsp").forward(req, resp);

                }

            }

        } else {
            resp.sendRedirect("404error.html");
        }
    }

}
