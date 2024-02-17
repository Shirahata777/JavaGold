package com.github.shirahata777.chapter9;

import java.io.Closeable;
import java.io.IOException;

// CloseableはAutoClosebleのサブクラス
public class TestCloseException2 implements Closeable {

    public void close() throws IOException {
        System.out.println("close");
    }
    
}
