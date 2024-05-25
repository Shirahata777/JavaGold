package com.github.shirahata777.chapter8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 何ももたずに、クラスに意味を追加することが目的のインターフェース
// public interface MarekerInterface {}
// アノテーションを利用して表現可能
// public @interface MarekerInterface{}

// 下記インタフェースのように有爵パラメータが一つ、かつパラメータ名がvalueの場合、
// アノテーションを付与する際に「@MarekerInterface("【パラメータ値】")」と書くことも可能
// public @interface MarekerInterface{
//     String value();
// }

// @Retentionでアノテーションの保持期間を指定可能
// 
// 実行時まで
// @Retention(RetentionPolicy.CLASS)
// 
// クラスファイルには残るが、実行時に消える
// @Retention(RetentionPolicy.RUNTIME)

// コンパイル時に情報が破棄される
@Retention(RetentionPolicy.SOURCE)
public @interface TestInterface{
    // デフォルト値を設定可能
    // 利用するときは「@DefaultValue」
    String name() default "アノテーション";
    int price();
}

