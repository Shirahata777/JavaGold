package com.github.shirahata777.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Sample1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        
        // オートボクシング機能追加前のラッパークラスからプリミティブ型要素の取り出し方
        for (int i = 0; i < list.size(); i++) {
            Integer obj = list.get(i);
            int num = obj.intValue();
            System.out.println(obj);
            System.out.println(num);
        }

        // オートボクシング
        Integer a = 10;
        // オートアンボクシング
        int b = new Integer(20);

        Value v = new Value("Hello");

        // オブジェクト型で取り出せる
        Object obj = v.getVal();

        List objList = new ArrayList<>();

        objList.add(10);
        objList.add("Hello!");

        // ダウンキャストするとjava.lang.ClassCastExceptionが発生する
        // String s = (String) objList.get(0);


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

}


