package com.github.shirahata777.chapter11;

import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) throws Exception {

        Object obj = Factory.create();

        // クラスの定義情報を取り出す
        Class clazz = obj.getClass();

        // メソッドの定義情報を取得
        Method[] methods = clazz.getDeclaredMethods();

        // インスタンスの定義情報を取得
        for(Method m : methods){
            System.out.println(m.invoke(obj));
        }

        
    }
    
}
