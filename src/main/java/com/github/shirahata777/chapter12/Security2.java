package com.github.shirahata777.chapter12;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.sql.Date;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Security2 implements Serializable {
    private Date date;
    // 機密情報を持つインスタンスをシリアライズする場合は「transient」を利用（フィールド自体はSシリアライズから外される）
    private transient String s;

    // 引数のオブジェクトをそのまま代入しない
    public Security2(Date date) {
        this.date = new Date(date.getTime());
    }

    // コピーコンストラクタ
    public Security2(Security2 input) {
        this.date = new Date(input.date.getTime());
    }

    // コピーしてから返却するようにする
    public Date getDate() {
        return (Date) date.clone();
    }

    // シリアライズ・プロキシパターン
    // writeReplace()はシリアライズする時
    private Object writeReplace(){
        return new SerializationProxy(date);
    }

    private static class SerializationProxy implements Serializable {

        private final Date d;

        SerializationProxy(Date date){
            this.d = date;
        }

        // デシリアライズする時
        private Object readResolve() {
            return new Security2(d);
        }
    
        
    }

}