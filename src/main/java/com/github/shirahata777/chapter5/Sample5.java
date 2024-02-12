package com.github.shirahata777.chapter5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
// ファイルの操作
import java.nio.file.Files;

// ファイルのパスを表現
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Sample5 {

    public static void main(String[] args) throws FileAlreadyExistsException, IOException  {

        Scanner scan = new Scanner(System.in);

        String ser = "src/main/java/com/github/shirahata777/chapter5/dir/sample.ser";

        // エラーが発生しない
        Path path = Paths.get(ser);
        Path path1 = Paths.get("src/main/java/com/github/shirahata777/chapter5/dir/", "sample.ser");
        Path path2 = new File(ser).toPath();

        // 絶対パスの取得
        System.out.println(path.toAbsolutePath());

        // ファイルを作成
        if (Files.exists(path2) == false) {
            // すでにファイルが存在する場合は、FileAlreadyExistsExceptionガスローされる
            Files.createFile(path2);
        }

        // lastmodifiedの出力
        System.out.println(Files.getLastModifiedTime(path2));
        // アクセス権の出力
        System.out.println(Files.getPosixFilePermissions(path2));

        // コマンドラインで「y」を入力したら実行
        if("y".equals(scan.nextLine())){
            // ファイルを削除
            Files.delete(path2);
            System.out.println("delete");
        }

        // コピー
        Files.copy(path1, Paths.get("src/main/java/com/github/shirahata777/chapter5/dir/copy.ser"));
        // 移動
        Files.copy(Paths.get("src/main/java/com/github/shirahata777/chapter5/dir/copy.ser"), Paths.get("src/main/java/com/github/shirahata777/chapter5/dir/copy2.ser"));

        
        // ファイル内のデータにアクセスする
        // StandardOpenOption.APPEND 追記モード
        // StandardOpenOption.CREATE ファイルが存在しない場合は新規作成
        // StandardOpenOption.CREATE_NEW 新規さフィル作成、既存にファイルが存在すると失敗
        // StandardOpenOption.DELETE_ON_CLOSE 閉じるときに入る削除
        // StandardOpenOption.READ 読み込みアクセス用に開く
        BufferedWriter out = Files.newBufferedWriter(path2, StandardOpenOption.APPEND);

        // 書き込み
        try(out){
            out.write("テスト");
            out.newLine();
        }


    }

}
