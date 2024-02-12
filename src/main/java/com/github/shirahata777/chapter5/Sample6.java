package com.github.shirahata777.chapter5;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class Sample6 {

    public static void main(String[] args) throws Exception {

        String dir = "src/main/java/com/github/shirahata777/chapter5/dir/";
        Path base = Paths.get(dir);

        // ディレクトリ内のファイル一覧
        Files.list(base).forEach(System.out::println);

        System.out.println("---------");

        // サブディレクト含め出力
        Files.walk(base).forEach(System.out::println);

        System.out.println("---------");

        BiPredicate<Path, BasicFileAttributes> bp = (p, attr) -> {
            return p.toFile().getName().endsWith(".txt");
        };

        // フィルター （パス, 階層, フィルター）
        Files.find(base, 3, bp).forEach(System.out::println);


        System.out.println("---------");

        // ディレクトリを扱い際にforを使う場合は、DirectoryStreamを利用する
        DirectoryStream<Path> dirs = Files.newDirectoryStream(base);

        for (Path p : dirs) {
            System.out.println(p.getFileName());
        }

    }

}
