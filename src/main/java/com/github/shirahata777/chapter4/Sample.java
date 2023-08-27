package com.github.shirahata777.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
        System.out.println(option3.orElseGet(() -> {
            return "a";
        }));

        // 「orElseThrow」を使うことで例外を発生させることも可
        // System.out.println(option3.orElseThrow(() -> new Exception()));

        // Optionalが空の場合は、関数を実行しない場合
        // option3.ifPresent((str) -> System.out.println(str));

        // Optionalが空の場合にも自国する場合は、「ifPresentOrElse」を使う
        option2.ifPresentOrElse((str)->System.out.println(str), ()->System.out.println("空"));

        // 並列ストリーム
        List<String> list1 = Arrays.asList("a","b","c","d","e");
        List<Integer> list2 = Arrays.asList(3,2,1,10,9);
        Stream<String> stream = list1.parallelStream();
        // stream.forEach(System.out::println); 

        // ランダムな値を取得「findAny()」
        // stream.findAny().ifPresent(System.out::println);

        // 初めの値を取得
         stream.findFirst().ifPresent(System.out::println);

        //  ソート
         list2.stream().sorted((a,b)-> {
            if (a > b) return 1;
            if (b > a) return -1;
            return 0;

         }).forEach(System.out::println);
        
         
         Optional<Integer> result = list2.stream().max((a,b) -> a.compareTo(b));
         result.ifPresent(System.out::println);


    }

}
