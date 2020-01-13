package com.Thealeshka;

import com.Thealeshka.data.result.GetResult;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("N  D  D_Av  S  C  T");
        new GetResult().getResult();
        System.out.println((date.getTime() - new Date().getTime())/-1000+" seconds");
    }
}
