package com.github.shirahata777.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Lambda {

    public static void main(String[] args) {
        // Supplier(引数を受け取らずに値を返す)
        Supplier<String> supplier = () -> "テスト";
        // 値を取得するときはget()を使う
        System.out.println(supplier.get());


        // Consumer(引数を受け取り、関数を実行)
        Consumer<String> consumer = (str) -> System.out.println(str);
        // 関数を実行する際はaccept()を使う
        consumer.accept("テスト２");

        BiConsumer<Integer, Integer> bic = (a, b) -> System.out.println(a + b);
        bic.accept(1, 2);


        // Predicate(引数を受け取り、booleanを返す)
        Predicate<String> predicate = (str) -> str instanceof String;
        // 判定する際は、test()を使う
        System.out.println(predicate.test("aaa"));

        // or,andメソッドが使える
        Predicate<String> predicate2 = (str) -> str.length() < 2;
        System.out.println(predicate.or(predicate2).test("aaa"));
        System.out.println(predicate.and(predicate2).test("aaa"));


        // Function(引数を受け取り、処理結果を返す)
        Function<Integer, Integer> function = (num) -> num * 2;
        System.out.println(function.apply("null".length()));

        // andThen,composeメソッドが使える（andThenは左の処理、composeは括弧内の処理が始めに実行される）
        Function<Integer, Integer> function2 = (num) -> num + 3;
        System.out.println(function.andThen(function2).apply("null".length()));
        System.out.println(function.compose(function2).apply("null".length()));


        // UnaryOperatorの利用例（x -> x.toUpperCase()部分が該当）
        UnaryOperator<String> unaryOperator = x -> x.toUpperCase();
        System.out.println(unaryOperator.apply("javascript"));

        List<String> list = new ArrayList(Arrays.asList("Java","Python","C#"));
        list.replaceAll(x -> x.toUpperCase());

        list.stream().forEach(s -> System.out.println(s));

    

    }

}
