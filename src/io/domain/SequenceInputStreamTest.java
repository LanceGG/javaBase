package io.domain;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Lance on 2017/12/25.
 */
public class SequenceInputStreamTest {

    public static void main(String[] args) {
        doSequence();
    }

    private static void doSequence() {
        SequenceInputStream sis = null;
        BufferedOutputStream bos = null;

        try {
            Vector<InputStream> vector = new Vector<InputStream>();
            vector.addElement(new FileInputStream("D:/work/text1.txt"));
            vector.addElement(new FileInputStream("D:/work/text2.txt"));
            vector.addElement(new FileInputStream("D:/work/text3.txt"));
            Enumeration<InputStream> e = vector.elements();

            sis = new SequenceInputStream(e);

            bos = new BufferedOutputStream(new FileOutputStream("D:/work/text4.txt"));

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = sis.read(buf)) != -1) {
                bos.write(buf, 0, len);
                bos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sis != null)
                    sis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
