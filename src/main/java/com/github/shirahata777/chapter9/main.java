package com.github.shirahata777.chapter9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.rmi.server.ExportException;

public class main {
    
    public static void main(String[] args) {

        try {
            
        } catch (ExceptionInInitializerError | RuntimeException e) { //マルチキャッチ（継承関係似ないもののみマルチ可能）

        }


        BufferedReader in = new BufferedReader(null);
        BufferedWriter out = new BufferedWriter(null);
        // try-with-resouce
        // 下記の場合、out inの順番でcloseされる
        // 括弧内はAutoCloseble Closebleいずれかで実装されたものを記載可能
        // close cacth finallyの順番で実行される
        try (in;out) {
            
        } catch (Exception e) {
            // 抑制された例外を扱う
            for(Throwable t : e.getSuppressed()){
                System.out.println(t);
            }
            // TODO: handle exception
        } finally {

        }
        
    }
}
