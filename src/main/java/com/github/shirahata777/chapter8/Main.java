package com.github.shirahata777.chapter8;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Item sample = new Item();

        List<String> messages = Reflection.validate(sample);
        for (String message : messages) {
            System.out.println(message);
        }

    }

}
