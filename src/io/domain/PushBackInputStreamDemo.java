package io.domain;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by Lance on 2017/12/25.
 */
public class PushBackInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String str = "hello,rollenholt";
        PushbackInputStream push = null;
        ByteArrayInputStream bat = null;
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat);
        int temp = 0;
        while ((temp = push.read()) != -1) {
            if(temp == ',') {
                push.unread(temp);
                temp = push.read();
                System.out.println("（回退" + (char) temp + ")");
            }else {
                System.out.println((char) temp);
            }
        }
    }
}
