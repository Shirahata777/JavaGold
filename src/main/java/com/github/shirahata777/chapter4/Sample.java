package com.github.shirahata777.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jcp.xml.dsig.internal.MacOutputStream;

public class Sample {

    public static void main(String[] args) throws Exception {

        // nullを入れるとエラーが発生する
        // Optional<String> option = Optional.of(null);

        // nullを許容する場合は「ofNullable」を使う
        Optional<String> option2 = Optional.ofNullable(null);

        // 空のOptionalインスタンスを作成
        Optional<String> option3 = Optional.empty();

        // エラーが発生
        // System.out.println(option2.get());
        // System.out.println(option3.get());

        // Optionalが空の場合に、他の値を戻す場合は「orElse」を使う
        // System.out.println(option3.orElse("テスト"));

        // Optionalが空の場合、「orElseGet」を使うことでSupploer型の関数を実行することも可
        // System.out.println(option3.orElseGet(() -> {
        //     return "a";
        // }));

        // 「orElseThrow」を使うことで例外を発生させることも可
        // System.out.println(option3.orElseThrow(() -> new Exception()));

        // Optionalが空の場合は、関数を実行しない場合
        // option3.ifPresent((str) -> System.out.println(str));

        // Optionalが空の場合にも自国する場合は、「ifPresentOrElse」を使う
        // option2.ifPresentOrElse((str) -> System.out.println(str), () -> System.out.println("空"));

        // 並列ストリーム
        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<Integer> list2 = Arrays.asList(3, 2, 1, 10, 9);
        Stream<String> stream = list1.parallelStream();
        // stream.forEach(System.out::println);

        // ランダムな値を取得「findAny()」
        // stream.findAny().ifPresent(System.out::println);

        // 初めの値を取得
        // stream.findFirst().ifPresent(System.out::println);

        // ソート
        // list2.stream().sorted((a, b) -> {
        //     if (a > b)
        //         return 1;
        //     if (b > a)
        //         return -1;
        //     return 0;

        // }).forEach(System.out::println);

        Optional<Integer> result = list2.stream().max((a, b) -> a.compareTo(b));
        // result.ifPresent(System.out::println);


        List<Item> list3 = Arrays.asList(
            new Item(1, ItemType.BOOK,"Java",1980),
            new Item(1, ItemType.BOOK,"Ruby",2000),
            new Item(1, ItemType.DVD,"Test",1000),
            new Item(1, ItemType.MAGAZINE,"Python",4322)
        );

        // リストで取り出したい時
        List<Item> bookList = list3.stream().filter(item -> item.getType() == ItemType.BOOK).collect(Collectors.toList());
        // Setで取り出したい時
        Set<Item> bookSetList = list3.stream().filter(item -> item.getType() == ItemType.BOOK).collect(Collectors.toSet());
        // Mapで取り出したい時
        Map<String, Item> bookSMap = list3.stream().filter(item -> item.getType() == ItemType.BOOK).collect(Collectors.toMap(
            Item::getName,
            item -> item
        ));

        // グルーピング
        Map<ItemType, List<Item>> group = list3.stream().collect(Collectors.groupingBy(Item::getType));
        // System.out.println(group);

        // フィールドごとに合計値を計算
        Map<ItemType, Integer> sum = list3.stream().collect(Collectors.groupingBy(
            Item::getType,
            Collectors.summingInt(Item::getPrice)));
        // System.out.println(sum);

        // フィールドごとに平均値を計算
        Map<ItemType, Double> average = list3.stream().collect(Collectors.groupingBy(
            Item::getType,
            Collectors.averagingInt(Item::getPrice)));
        // System.out.println(average);

        // 条件によってグルーピング（条件通りならtrue それ以外はfalse）
        Map<Boolean, List<Item>> partition = list3.stream().collect(Collectors.partitioningBy(item -> item.getPrice() >= 2000));
        // System.out.println(partition);

    }

}
