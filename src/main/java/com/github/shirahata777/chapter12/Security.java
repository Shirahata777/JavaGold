package com.github.shirahata777.chapter12;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Security {

    public static void main(String[] args) {
        
        String inputText = "\u3066\u3099";
        // Unicodeで正規化
        String result = Normalizer.normalize(inputText, Form.NFD);
        System.out.println(result);

        // 整数オーバーフロー対策
        // ①事前条件テスト
        // ②アップキャスト（できればこれを使う）
        // ③BigInteger（大きな数値を扱う場合）

        
    }
    
}
