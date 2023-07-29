package com.github.shirahata777.chapter1;

public interface Sample {

    public final static String A = "APPLE";
    public final static String B = "BANANA";
    public final static String C = "CANDY";


    default void test() {
        System.out.println("デフォルトメソッドのテスト");
    }

    static void execute() {
        System.out.println("テスト");
    };

    // インターフェースにもprivateメソッドを追加可能
    private void a() {
         System.out.println("テスト");
    };
    private static void d() {
         System.out.println("テスト");
    };

    // 下記のようには記載できない
    
}
