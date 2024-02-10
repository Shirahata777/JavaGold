package com.github.shirahata777.chapter5;

import java.util.Scanner;

public class Sample3 {

    public static void main(String[] args) {

        // 文字の入力ストリームを扱う
        Scanner scanner = new Scanner("A,B,C,D,E,F");

        // 特定の文字で分割
        scanner.useDelimiter(",");

        try (scanner) {
            // scanner.next()で一行ずつ読み込む
            System.out.println(scanner.next());
            System.out.println(scanner.next());
            System.out.println(scanner.next());
            System.out.println(scanner.next());
            System.out.println(scanner.next());
            System.out.println(scanner.next());
        }
    }

}
