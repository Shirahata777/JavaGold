package com.github.shirahata777.chapter7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Sample2 {

    public static void main(String[] args) {
        // FIFO形式（先入先出し）のリストを作成可能
        Queue<Integer> que = new ArrayDeque<>(4);
        que.add(1);
        que.add(2);
        que.add(2);
        que.add(2);
        que.add(2);
        // que.stream().forEach(System.out::println);

        // 配列の先頭・後方から値を取り出せる
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addFirst("d");
        // deque.stream().forEach(System.out::println);

        // 重複を許容しない
        // HashSetは並び順を保証しない
        Set<String> set = new HashSet<>();
        set.add("null");
        set.add("null");
        set.add("test");
        // set.stream().forEach(System.out::println);

        // 要素順に並ぶ
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("1");
        treeSet.add("B");
        treeSet.stream().forEach(System.out::println);

        // 一意のキーと紐づけられた値のペア要素
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "test");
        map.put(2, "null");
        map.keySet().stream().forEach(key -> {
            System.out.println(map.get(key));
        });

        var a = Map.entry(1, "test");
        var b = Map.entry(2, "null");

        Map<Integer, String> map2 = Map.ofEntries(a,b);

        // for(Map.Entry<Integer, String> entry: map2.entrySet()){
        //     System.out.println(entry.getKey() + ":" + entry.getValue()); 
        // }

        map2.entrySet().stream().forEach((Map.Entry<Integer, String> m) -> {
            System.out.println(m.getKey() + ":" + m.getValue());
        });

    }
    
}
