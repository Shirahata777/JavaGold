package com.github.shirahata777.chapter8;

public class OverrideClass1 {
    public void A(String name) {
        System.out.println(name);
    }

    // 非推奨のメソッドに付与
    @Deprecated
    public void B(String name) {
        System.out.println(name);
    }
}
