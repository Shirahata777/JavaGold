package com.github.shirahata777.chapter7;

import java.util.ArrayList;
import java.util.List;

public class CastTest {

    public static void main(String[] args) {

        // 左プリミナティブ型、右ラッパークラス（オートアンボクシング形式で記載）
        byte b = new Byte("ss");
        short s = new Short(b);
        int i = new Integer(1);
        long l = new Long(null);
        double d = new Double(l);
        float f = new Float(null);
        char c = new Character('s');
        boolean bool = new Boolean(false);

        // オートボクシング形式
        Byte bb = 0;
        Short ss = 1;
        Integer ii = 10;
        Long ll = 123l;
        Double dd = 1.0;
        Float ff = 1.0f;
        Character cc = 'a';
        Boolean bo = true;

        // オートボクシング機能追加前のラッパークラスからプリミティブ型要素の取り出し方
        List<Integer> list = new ArrayList<>();

        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));

        for (int count = 0; i < list.size(); i++) {
            Integer obj = list.get(count);
            int num = obj.intValue();
            System.out.println(obj);
            System.out.println(num);
        }

        // オブジェクト型で取り出せる
        Value v = new Value("Hello");
        Object test1 = v.getVal();

        // 下記場合は、ダウンキャストするとjava.lang.ClassCastExceptionが発生する
        List objList = new ArrayList<>();
        objList.add(10);
        objList.add("Hello!");
        String test2 = (String) objList.get(0);

    }

}
