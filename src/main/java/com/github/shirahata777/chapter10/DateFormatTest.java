package com.github.shirahata777.chapter10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatTest {
    
    public static void main(String[] args) {
        // 日付時刻を扱う
        // 出力例: 20240224
        DateTimeFormatter BasicIsoFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(BasicIsoFormatter.format(LocalDate.now()));

        // 出力例: 2024-02-24
        DateTimeFormatter IoslocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(IoslocalDate.format(LocalDate.now()));

        // 出力例: 20:51:39.08057
        DateTimeFormatter IoslocalTime =DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println(IoslocalTime.format(LocalTime.now()));

        // 出力例: 2024-055
        DateTimeFormatter IsoOrdinalDate = DateTimeFormatter.ISO_ORDINAL_DATE;
        System.out.println(IsoOrdinalDate.format(LocalDate.now()));

        // 出力パターンを変更可能
        DateTimeFormatter FormatDate = DateTimeFormatter.ofPattern("YYYY年MM月DD日");
        System.out.println(FormatDate.format(LocalDate.now()));

        // ローカライズされたスタイルを利用する場合
        Locale.setDefault(Locale.JAPAN);
        DateTimeFormatter date1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(date1.format(LocalDate.now()));

    }
}
