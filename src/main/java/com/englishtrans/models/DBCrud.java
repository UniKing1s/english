package com.englishtrans.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBCrud {
    public static List<WordMean> getListOfWord(Connection conn){
        List<WordMean> lW = new ArrayList<>();
        String query = "SELECT * FROM wordtranslation order by TIME desc";
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String word = rs.getString("WORD");
                String mean = rs.getString("MEAN");
                Date time = rs.getTimestamp("TIME");
                WordMean wM = new WordMean(word, mean, time);
                lW.add(wM);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lW;
    }
    public static void updateWord(Connection conn, WordMean wm){
        String query = "UPDATE wordtranslation SET MEAN =?, TIME = ? where WORD = ?";
        Timestamp tsm = new Timestamp(new Date().getTime());
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, wm.getMean());
            ps.setTimestamp(2, tsm);
            ps.setString(3, wm.getWord());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static WordMean getWordByID(Connection conn, String word){
        WordMean wm = null;
        String query = "SELECT * FROM wordtranslation where WORD = ?";
        ResultSet rs = null;
        try {

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, word);
            rs = ps.executeQuery();
            while (rs.next()) {
                String w = rs.getString("WORD");
                String mean = rs.getString("MEAN");
                Date time = rs.getTimestamp("TIME");
                wm = new WordMean(word, mean, time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wm;
    }
    public static void addWord(Connection conn, WordMean wM){
        String query ="INSERT INTO wordtranslation values(?,?,?)";
        String qr = "insert into wordtranslation values(?,?,?);";
        try {
            Date date = new Date(); 
            java.sql.Timestamp dat = new java.sql.Timestamp(date.getTime());
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, wM.getWord());
            ps.setString(2, wM.getMean());
            ps.setTimestamp(3, dat);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteWord(Connection conn, String word){
        String query = "DELETE FROM wordtranslation where WORD = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, word);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
