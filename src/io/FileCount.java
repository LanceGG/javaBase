package io;

import java.io.*;

/**
 * Created by Lance on 2017/12/24.
 */
public class FileCount {

    public static void main(String[] args) {
        int count = 0;
        byte[] bytes = new byte[512];
        FileInputStream input = null;
        FileOutputStream out = null;
        try {
            input = new FileInputStream("D:/work/java.docx");
            out = new FileOutputStream("D:/work/java2.docx");
            while ((count = input.read(bytes)) != -1) {
                out.write(bytes, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
