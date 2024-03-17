package com.github.shirahata777.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PeekTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
            .map(x -> x * 3)
            // 中間処理
            .peek(x -> System.out.println("debug:" + x))
            .filter(x -> x % 2 == 0)
            .forEach(x -> System.out.println(x));

        // Stream型で終端操作を２回呼び出すと「java.lang.IllegalStateException」が発生
        // Integer[] array = {1,2,3};
        // Stream<Integer> stream = Arrays.stream(array);

        // stream.forEach(x -> System.out.println(x));
        // stream.forEach(x -> System.out.println(x));
    }
    
}
