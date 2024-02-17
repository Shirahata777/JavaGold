package com.github.shirahata777.chapter8;

public class OverrideClass2 extends OverrideClass1 {

    // スーパークラスのメソッドの変更を検知し、
    // メソッドとシグニチャが変更されていたらコンパイルエラー（下記の場合もエラーが発生）
    @Override
    // コンパイラが発する警告を抑制
    @SuppressWarnings("unchecked") // 警告をオフ
    public void A() {
        System.out.println("オーバーライド");
    }
}
