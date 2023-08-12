package com.github.shirahata777.chapter3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;


// Callableインターフェースでの例外は、「ExecutionException」に保持される
public class SampleThread2 {


    // // Callableインターフェースでの例外は、「ExecutionException」に保持される
    // public static void main(String[] args) throws InterruptedException {

    //     ExecutorService exec = Executors.newSingleThreadExecutor();
    //     List<Future<Boolean>> futures = new ArrayList<>();

    //     for (int i = 0; i < 10; i++) {
    //         futures.add(exec.submit(() -> {
    //             if(new Random().nextInt() % 2 != 0) {
    //                 throw new Exception("Odd Number");
    //             }
    //             return true;
    //         }));
    //     }

    //     int total = 0;

    //     for (Future<Boolean> future : futures){
    //         Boolean result = false;

    //         try {
    //             result = future.get();
    //             System.out.println(result);

    //         } catch (ExecutionException e) {
    //              System.out.println(e.getMessage());
    //         }

    //         if(result){
    //             total++;
    //         }
    //     }

    //     System.out.println(total);


    // }

    //CyclicBarrier（同期処理の際に利用）の使用例
     public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);

        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("It`s all done");
        });

        for(int i = 0;i < 5; i++){
            exec.submit(new Task(barrier));
        }

     }


}
