package com.github.shirahata777.chapter3;

import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SampleThread {

    public static void main(String[] args) throws Exception {
        // Thread t = new Thread() {
        // @Override
        // public synchronized void start() {
        // super.start();
        // System.out.println("A");
        // }

        // @Override
        // public void run() {
        // super.run();
        // System.out.println("B");
        // }
        // };

        // run()しか実行されない
        // t.run();
        // run()も実行される
        // t.start();

        // 下記のように記載も可
        // Thread t2 = new Thread(() -> System.out.println("B")) ;
        // t2.run();

        // スレッドを一つだけ作成し、プールしている
        // ExecutorService execSingle = Executors.newSingleThreadExecutor();

        // for (int i = 0; i < 5;i++) {
        // execSingle.submit(() -> {
        // System.out.println(Thread.currentThread().getId());
        // });
        // };

        // 作成するスレッドの個数を指定
        // ExecutorService execFixed = Executors.newFixedThreadPool(3);

        // for (int i = 0; i < 5;i++) {
        // execFixed.submit(() -> {
        // System.out.println(Thread.currentThread().getId());
        // });
        // };

        // 必要に応じてスレッド数が変化する（使用後60秒間使用されなければ破棄、60秒以内のものは再使用）
        // ExecutorService execCached = Executors.newCachedThreadPool();

        // for (int i = 0; i < 5; i++) {
        // execCached.submit(() -> {
        // System.out.println(Thread.currentThread().getId());
        // });
        // };

        // 指定した時間後にスレッドを実行
        // ScheduledExecutorService execSchedule =
        // Executors.newSingleThreadScheduledExecutor();
        // for (int i = 0; i < 5; i++) {
        // execSchedule.schedule(() ->
        // System.out.println(Thread.currentThread().getId()), 1, TimeUnit.SECONDS);
        // }

        // 定期的に実行する場合は「scheduleAtFixedRate」を使う
        // execSchedule.scheduleAtFixedRate(() ->
        // System.out.println(Thread.currentThread().getId()),1 , 1, TimeUnit.SECONDS);

        // 一定間隔で処理を実行
        // execSchedule.scheduleWithFixedDelay(() ->
        // System.out.println(Thread.currentThread().getId()), 1, 1,
        // TimeUnit.SECONDS);

        // 複数スレッドを効率よく使いたい場合
        // ScheduledExecutorService execSchedule = Executors.newScheduledThreadPool(2);


        // Futureを利用することで、スレッド終了時に「null」を受け取れる
        // 第二引数に戻り値を設定可能
        // ExecutorService execSingle = Executors.newSingleThreadExecutor();
        // Future future = execSingle.submit(() -> {

        //     try {
        //         System.out.println("start");
        //         Thread.sleep(2000);
        //         System.out.println("end");

        //     } catch (Exception e) {
        //         throw new RuntimeException();

        //     }
        // });

        // if (future.get() == null) {
        //     System.out.println("finish");
        // }

    }

}
