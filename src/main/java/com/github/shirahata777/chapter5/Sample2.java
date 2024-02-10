package com.github.shirahata777.chapter5;

import java.io.Console;

public class Sample2 {

    public static void main(String[] args) {

        Console user = System.console();
        // readLineはstr型
        String s = user.readLine();

        Console pass = System.console();
        // readPasswordはchar[]型
        char[] c = pass.readPassword();

        System.out.println(s);
        System.out.println(String.valueOf(c));

    }

}
