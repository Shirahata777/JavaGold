package com.github.shirahata777.chapter7;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {

        // 変数への代入時（ダイヤモンド演算子を利用可能）
        List<String> list2 = new ArrayList<>();

        // メソッドの呼び出しの引数（ダイヤモンド演算子を利用可能）
        Object o = testmethod(new ArrayList<>());

        // ジェネリクス宣言時にextendsを利用することで、特定のクラス・サブクラスに限定可能
        class InnerCollectionTest<T extends TestMethod> {
            public void execute(T t){
                t.hello();
            }
        }
        // 下記場合だと型が定まっていないので、コンパイルエラー
        // class InnerCollectionTest<T extends TestMethod> {
        //     public void execute(T t){
        //         t.hello();
        //     }
        // }

        InnerCollectionTest<TestMethod> ct = new InnerCollectionTest<>();
        ct.execute(new TestMethod());
        InnerCollectionTest<TestOverrideMethod> ct2 = new InnerCollectionTest<>();
        ct2.execute(new TestOverrideMethod());
        // 下記場合はサブクラスでもないのでコンパイルエラーが発生
        // InnerCollectionTest<TestNoOverrideMethod> ct3 = new InnerCollectionTest<>();



        // ジェネリクス部分は非変
        // List<Integer> test = new ArrayList<Integer>();
        // List<Integer> test = new ArrayList<Object>();

        // ワイルドカード（非境界ワイルドカード）「?」が利用可能
        // List<?> test = new ArrayList<Object>();

        // 非境界ワイルドカードを利用すると返り値はObject型になる
        Value<?> v2 = new Value("Hello");

        // nunllしか渡せない（コンパイルエラー）

        // v2.setValue("sample");
        v2.setValue(null);

    }

    // メソッドの戻り値（ダイヤモンド演算子を利用可能）
    private static List<String> testmethod(List<String> a) {
        return new ArrayList<>();
    }
    
}
