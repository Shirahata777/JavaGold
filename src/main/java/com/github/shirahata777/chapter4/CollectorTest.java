package com.github.shirahata777.chapter4;

import java.util.Arrays;
import java.util.List;

public class CollectorTest {

    public static void main(String[] args) {

        // ラムダ式内部から、外部のオブジェクトを操作している（副作用のある処理）
        // List<String> list = Arrays.asList("A", "B", "C", "D", "E");
        // StringBuilder builder = new StringBuilder();

        // list.stream().forEach(str -> {
        //     if (builder.length() != 0) {
        //         builder.append(",");
        //     }
        //     builder.append(str);
        // });
        // System.out.println(builder);

        // 副作用がないようにCollecterを利用する場合
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        // String result = list.stream().collect(new SampleCollector());
        // combiner()が return null の時はエラーを吐く
        String result = list.parallelStream().collect(new SampleCollector());
        System.out.println(result);

    }

}
