package com.englishtrans.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.englishtrans.models.DBCrud;
import com.englishtrans.models.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteWordServletController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        //get connect
        Connection conn = MySQLConnection.getMySQLConnection();
        //Thực hiện xóa
        DBCrud.deleteWord(conn, word);
        //Close connect
        MySQLConnection.closeConnection(conn);
        resp.sendRedirect("wordList");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
