package com.github.shirahata777.chapter10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest1 {

    public static void main(String[] args) throws Exception {
        // プロパティファイルの読み込み
        // Charsetで文字コード（UTF-8, ISO-8859-1 いずれか）を指定可能
        // InputStreamReaderを利用することも可能
        Properties prop = new Properties();
        prop.load(new FileReader("sample.properties", Charset.forName("UTF-8")));
        // prop.load(new InputStreamReader(new FileInputStream("sample.properties"), "utf-8"));
        // プロパティ一覧出力①
        prop.forEach((k, v) -> System.out.println(v));
        // プロパティ一覧出力②
        Set keys = prop.keySet();
        for (Object key : keys) {
            System.out.println(prop.get(key));
        }
        // プロパティ一覧出力③
        prop.list(System.out);

        // 取り出すプロパティのkeyが決まっている場合
        System.out.println(prop.getProperty("test"));

    }

}
