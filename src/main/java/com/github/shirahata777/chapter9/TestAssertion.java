package com.github.shirahata777.chapter9;

public class TestAssertion {

    private String name;
    private int price;

    public TestAssertion(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // asssetで不正な値が入っていないか確認
        // アサーションを有効にする場合は「java -ea ~」コマンドで実行する
        // nullの場合にAssertionErrorが発生（trueの場合はエラーが発生しない）
        assert name != null : "name is null";
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        // 0以下の時にエラー発生
        assert price > 0 : "invaild price";
        this.price = price;
    }

}
