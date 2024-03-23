package com.github.shirahata777.chapter6;

//  java.sqlはインターフェースだけではなく、例外・SQL操作に共通するクラスも提供している
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sample {

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jbdc:derby://localhost:1527/data/Sample");

            System.out.println("con");
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            // DBMSの同時接続に限りがある為、通信が終わるたびにclose()を用いて閉じなければいけない
            con.close();
        }
    }

}
