package com.github.shirahata777.chapter9;

public class TestCloseException1 implements AutoCloseable {

    public void close() throws Exception{
        System.out.println("close");
    }
    
}
