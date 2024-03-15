package com.github.shirahata777.chapter4;

import java.nio.charset.CharsetEncoder;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SampleCollector implements Collector<String, StringBuilder, String> {

    // 処理途中の値を保持
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    // 具体的な処理を記述
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (builder, str) -> {
            if (builder.length() != 0) {
                builder.append(",");
            }
            builder.append(str);
        };
    }

    // 並列処理中の処理中の値を保持するためのオブジェクトを結合する
    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (a, b) -> {
            if(a.length() != 0){
                a.append(",");
            }
            a.append(b);
            return a;
        };

    }

    // 処理結果を返すラムダ式をセット
    @Override
    public Function<StringBuilder, String> finisher() {
        return builder -> builder.toString();
    }

    // このCollectorの特徴を記載
    @Override
    public Set<Characteristics> characteristics() {
        // 特徴として記載するものがない時
        return EnumSet.noneOf(Characteristics.class);

        // 並列処理することを表す
        // return EnumSet.of(Characteristics.CONCURRENT);

        // finisherが省略可能であることを表す
        // return EnumSet.of(Characteristics.IDENTITY_FINISH);

        // コレクション操作で順番を保証しないことを表す
        // return EnumSet.of(Characteristics.UNORDERED);
    }

}
