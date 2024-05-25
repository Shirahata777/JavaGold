package com.github.shirahata777.chapter5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
// java.io.File;はファイル・ディレクトリのパスのみを扱うクラス
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sample {

    public static void main(String[] args) throws IOException {

        String filePath = "src/main/java/com/github/shirahata777/chapter5/dir/";

        File dir = new File(filePath);

        // ディレクトリ作成
        if (dir.exists() == false) {
            dir.mkdir();
        }

        File file = new File(filePath + "data.txt");

        // ファイル作成
        if (file.exists() == false) {
            file.createNewFile();
        }

        // System.out.println(file.getAbsolutePath());

        // ファイル一覧を取得
        for (File f : dir.listFiles()) {
            System.out.println(f);
        }

        FileReader reader = null;
        try {
            reader = new FileReader(filePath + "data.txt");
            int i = 0;

            while ((i = reader.read()) != -1) {
                char c = (char) i;
                System.out.print(c);
            }
        } finally {
            if (reader != null) {
                System.out.print("\n");
                reader.close();
            }

        }

        FileReader fr = new FileReader(filePath + "data.txt");
        BufferedReader br = new BufferedReader(fr);

        try(br) {
            br.lines().forEach(System.out::println);
        }

        // ファイルへの書き込み（ture: 追記 false: 上書き）
        FileWriter out = new FileWriter(filePath + "data.txt", true);
        BufferedWriter writer = new BufferedWriter(out);


        try(writer){
            // 改行
            writer.newLine();
            // バッファに書き込み
            writer.write("テストの書き込み");
            // 強制書き込み（バッファとファイルの同期）
            writer.flush();
        }

        


    }

}
