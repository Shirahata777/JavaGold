package com.github.shirahata777.chapter10;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.JAPAN);

        // 通常の数字フォーマット
        NumberFormat num1 = NumberFormat.getInstance();

        // 整数型数値のフォーマット
        NumberFormat num2 = NumberFormat.getIntegerInstance();
        
        // 通過フォーマット
        NumberFormat num3 = NumberFormat.getCurrencyInstance();

        // パーセントと表記のフォーマット
        NumberFormat num4 = NumberFormat.getPercentInstance(Locale.US);

    }
    
}
