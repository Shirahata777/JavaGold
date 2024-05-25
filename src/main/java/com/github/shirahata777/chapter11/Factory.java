package com.github.shirahata777.chapter11;

public class Factory {
    public static Object create() {
        return new Item("apple", 100);
    }

}
