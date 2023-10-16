package com.englishtrans.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.englishtrans.models.DBCrud;
import com.englishtrans.models.MySQLConnection;
import com.englishtrans.models.WordMean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/wordList")
public class WordListServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay ket noi
        Connection conn = MySQLConnection.getMySQLConnection();
        //Lay du lieu
        List<WordMean> wm = DBCrud.getListOfWord(conn);
        //Dong KetNoi
        MySQLConnection.closeConnection(conn);
        req.setAttribute("list", wm);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/wordListView.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
