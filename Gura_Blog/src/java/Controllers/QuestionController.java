/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DataAccess.QuestionDAO;
import Models.Posts;
import Models.Questions;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class QuestionController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String answ1 = String.valueOf(session.getAttribute("answ1"));
        String answ2 = String.valueOf(session.getAttribute("answ2"));
        String answ3 = String.valueOf(session.getAttribute("answ3"));
        String answ4 = String.valueOf(session.getAttribute("answ4"));
        
        
        
        
     
            }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        QuestionDAO q = new QuestionDAO();
        
        
        String answ1 = req.getParameter("answ1");
        String answ2 = req.getParameter("answ2");
        String answ3 = req.getParameter("answ3");
        String answ4 = req.getParameter("answ4");
        
        
        session.setAttribute("answ1", answ1);
        session.setAttribute("answ2", answ2);
        session.setAttribute("answ3", answ3);
        session.setAttribute("answ4", answ4);
        
        //gettotalpost
        int totalQuestion = q.getTotalQuestion();
        int endPage = totalQuestion / 1;
        if (totalQuestion % 1 != 0) {
            endPage++;
        }
        req.setAttribute("endPage", endPage);

        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        ArrayList<Questions> listPageQuestion = (ArrayList<Questions>) q.getPageQuestionView(index);
        req.setAttribute("listPageQuestion", listPageQuestion);
        req.setAttribute("tagPage", index);
        
//        ArrayList<Questions> listQuestion = (ArrayList<Questions>) q.getListQuestionTop1();
//        req.setAttribute("listQuestion", listQuestion);
        
        
        req.getRequestDispatcher("question.jsp").forward(req, resp);
        
    }
    
    
    
    
    
    
}
