package com.github.shirahata777.chapter1;


/* 
 * ネストクラス
 *  ・インナークラス
 *  ・staticインナークラス
 *  ・ローカルクラス
 *  ・匿名クラス
*/
public class NestClass {

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
        class LocalClass {
            public void test (){
                System.out.println("ローカルクラステスト！");
            }
        }

        // ローカルクラスの実行方法
        new LocalClass().test();
    }



    public static void main(String[] args) {
        // インナークラス内のメソッド実行方法
        new NestClass().new InnerClass().test();

        // staticインナークラス内のメソッド実行方法
        new StaticInnnerClass().test();

        // ローカルクラス実行方法
        NestClass.TestMethod();

    }
}
