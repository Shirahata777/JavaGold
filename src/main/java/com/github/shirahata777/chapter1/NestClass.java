package com.github.shirahata777.chapter1;

/* 
 * ネストクラス
 *  ・インナークラス
 *  ・staticインナークラス
 *  ・ローカルクラス
 *  ・匿名クラス
*/

enum EnumTest {
    A,B,C;
}
public class NestClass implements Sample {

    private int num = 2;
    public String str = "a";
    static int staticNum = 1;

    // インナークラス
    public class InnerClass {
        public void test() {
            System.out.println("インナークラステスト！");

            //
            System.out.println(num);
            System.out.println(str);
            System.out.println(staticNum);
        }
    }

    // staticインナークラス
    static class StaticInnnerClass {
        public void test() {
            System.out.println("staticインナークラステスト！");

            // エンクロージングクラスの変数（static以外）にアクセスできない
            // System.out.println(num);
            // System.out.println(str);
            System.out.println(staticNum);
        }
    }

    public static void TestMethod() {
        // ローカルクラス
        class LocalClass {
            public void test() {
                System.out.println("ローカルクラステスト！");
            }
        }

        // ローカルクラスの実行方法
        new LocalClass().test();
    }

    // 匿名クラス
    Runnable run = new Runnable() {
        @Override
        public void run() {
            System.out.println("匿名クラス");
        }
    };

    // 匿名クラスにはコンストラクターを設定できない
    // Sample sample = new Sample() {

    // public Sample() {
    // System.out.println("匿名クラス");
    // };

    // };

    public static void execute() {
        System.out.println("テスト2");
    };

    // デフォルトメソッドのオーバーライドについて
    @Override
    public void test() {
        Sample.super.test();

    }

    public static void main(String[] args) {
        // インナークラス内のメソッド実行方法
        new NestClass().new InnerClass().test();

        // staticインナークラス内のメソッド実行方法
        new StaticInnnerClass().test();

        // ローカルクラス実行方法
        NestClass.TestMethod();

        // インターフェースのメソッド
        Sample.execute();

        // 同ファイル内のメソッド
        execute();

        // Enum内のインスタンスの取得方法
        System.out.println(EnumTest.values()[0]);
        System.out.println(EnumTest.valueOf("A"));

    }
}
