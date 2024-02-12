package com.github.shirahata777.chapter7;

// 制限付型パラメータ（extendsを利用する）
public class Value<T extends Object>{

    T val;

    public Value(T val){
        super();
        this.val = val;
    }

    public T getVal(){
        return val;
    }

    public void setValue(T value){
        this.val = value;
    }

}