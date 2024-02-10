package com.github.shirahata777.chapter5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// シリアライズ化
public class Item implements Serializable {

    private String name;
    private int price;

    public Item(String name , int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "name: " + name + " price: " + price;
    }

    // カスタムシリアライズ
    // private void writeObject(ObjectOutputStream out){

    // }

    // カスタムデシリアライズ
    // private void readObject(ObjectInputStream in){

    // }
    
}
