package io;

import java.io.*;

/**
 * Created by Lance on 2017/12/26.
 */
public class FileConcatenate {

    public static void main(String[] args) {
        try {
            concennateFile(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void concennateFile(String ... fileName) throws IOException {
        String str;
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/work/text4.txt"));
        for(String name: fileName) {
            BufferedReader reader = new BufferedReader(new FileReader(name));

            while ((str = reader.readLine()) != null) {
                writer.write(str);
                writer.newLine();
            }
        }
        writer.flush();
        writer.close();
    }
}
