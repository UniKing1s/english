package com.englishtrans.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WordMean {
    private String word;
    private String mean;
    private Date time;
    public WordMean() {
    }


    public WordMean(String word, String mean, Date time) {
        this.word = word;
        this.mean = mean;
        this.time = time;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        mean = mean;
    }


    public Date getTime() {
        return time;
    }


    public void setTime(Date time) {
        this.time = time;
    }
    
    
}
