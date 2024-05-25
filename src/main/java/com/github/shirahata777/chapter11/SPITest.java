package com.github.shirahata777.chapter11;

import java.util.ServiceLoader;

import java.util.Iterator;

public class SPITest {
    
    public static void main(String[] args) {
        
        // loadにはクラスリテラルを挿入
        Iterator<Hello> hellos = ServiceLoader.load(Hello.class).iterator();

        while(hellos.hasNext()){
            Hello h =hellos.next();
            System.out.println(h.Hello());
        }
    }
}
