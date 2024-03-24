package com.github.shirahata777.chapter10;

import java.util.Locale;

public class LocateTest {

    public static void main(String[] args) {
        // ロケール情報のインスタンスを取得①（getDefault）
        Locale locale1 = Locale.getDefault();

        // ロケール情報のインスタンスを取得②（コンストラクター）
        Locale locale2 = new Locale("ja", "JP");

        // ロケール情報のインスタンスを取得③（ロケール定数）
        Locale locale3 = Locale.US;

        // ロケール情報のインスタンスを取得④（ビルダー）
        Locale locale4 = new Locale.Builder().setLanguage("ja").setRegion("JP").setScript("Japan").build();

        // ロケール情報のインスタンスを取得⑤（forLanguageTag）
        Locale locale5 = Locale.forLanguageTag("en-US-xlvariant-POSIX");
    }
    
}
