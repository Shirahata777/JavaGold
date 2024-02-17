package com.github.shirahata777.chapter8;

// クラスへのアノテーション付与
// あの手ションで使う値（下記の場合は「name」「price」は注釈パラメータ）
@TestInterface(name= "test", price = 100)
public class Item {
    private String name;

    @NotNullInterface(messege = "金額が入っていません")
    private Integer price;

    public Item(){
        this.name = name;
        this.price = price;
    }
}
