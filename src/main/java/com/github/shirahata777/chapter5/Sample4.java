package com.github.shirahata777.chapter5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sample4 {

    public static void main(String[] args) throws Exception {

        String ser = "src/main/java/com/github/shirahata777/chapter5/dir/sample.ser";

        File file = new File(ser);

        // ファイル作成
        if (file.exists() == false) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(ser);

        // シリアライズ化して書き出し
        ObjectOutputStream out = new ObjectOutputStream(fos);
        try (out) {
            Item item = new Item("apple", 100);
            out.writeObject(item);
        }

        // デシリアライズして出力
        FileInputStream fis = new FileInputStream(ser);

        ObjectInputStream in = new ObjectInputStream(fis);
        try (in) {
            Object obj = in.readObject();
            Item item = (Item) obj;
            System.out.println(item);
        }  

    }

}
