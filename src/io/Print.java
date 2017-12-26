package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lance on 2017/12/25.
 */
public class Print {

    public static void main(String[] args) {

        char[] buffer = new char[512];
        int numberRead = 0;
        FileReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new FileReader("D:/work/text1.txt");
            writer = new PrintWriter(System.out);

            while ((numberRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, numberRead);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }

}
