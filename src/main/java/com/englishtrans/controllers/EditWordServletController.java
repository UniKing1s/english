package com.englishtrans.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.englishtrans.models.DBCrud;
import com.englishtrans.models.MySQLConnection;
import com.englishtrans.models.WordMean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditWordServletController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        //lay ket noi
        Connection conn = MySQLConnection.getMySQLConnection();
        ///lấy dữ liệu
        WordMean wm = DBCrud.getWordByID(conn, word);
        //Đóng kết nối
        MySQLConnection.closeConnection(conn);
        req.setAttribute("word", wm);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/editView.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        if(submit.equals("Submit")){
            String word = req.getParameter("word");
            String mean = req.getParameter("mean");
            WordMean wm = new WordMean(word, mean, null);
            //Lấy kết nối sql
            Connection conn = MySQLConnection.getMySQLConnection();
            //Thực hiện update;
            DBCrud.updateWord(conn, wm);
            //Đóng kết nối
            MySQLConnection.closeConnection(conn);
        }
        //Quay lại danh sách
        resp.sendRedirect("wordList");
       
    }
}
