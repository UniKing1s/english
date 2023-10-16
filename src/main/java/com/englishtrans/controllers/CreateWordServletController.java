package com.englishtrans.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import com.englishtrans.models.DBCrud;
import com.englishtrans.models.MySQLConnection;
import com.englishtrans.models.WordMean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class CreateWordServletController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createWordView.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        if (submit.equals("Submit")) {
            String word = req.getParameter("word");
            String mean = req.getParameter("mean");
            Date date = new Date();
            //get connect
            Connection conn = MySQLConnection.getMySQLConnection();
            //tạo đối tượng
            WordMean wm = new WordMean(word, mean, date);
            System.out.println("Word: " + wm.getWord());
            System.out.println("Mean: " + wm.getMean());
            System.out.println("date: " + wm.getTime());

            //add vô data
            DBCrud.addWord(conn, wm);
            //close
            MySQLConnection.closeConnection(conn);
        }
        resp.sendRedirect("wordList");
    }
}
