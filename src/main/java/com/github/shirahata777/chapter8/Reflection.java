package com.github.shirahata777.chapter8;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


// リフレクション（インタンス元のクラスの定義情報を調べ、操作する）
public class Reflection {

    public static List<String> validate(Object target) {

        // Class<Item> clazz = Item.class;
        // アノテーション情報の取得
        // TestInterface annotation = clazz.getAnnotation(TestInterface.class);

        // 注釈パラメータの取得
        // String name = annotation.name();
        // int price = annotation.price();

        try {
            List<String> messages = new ArrayList<>();

            Field[] fields = target.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                NotNullInterface annotation = field.getAnnotation(NotNullInterface.class);

                if (annotation == null) {
                    continue;
                }

                messages.add(annotation.messege());
            }

            return messages;

        } catch (IllegalArgumentException | IllegalAccessError e) {
            throw new RuntimeException(e);
        }
    }

}
