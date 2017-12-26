package io.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * Created by Lance on 2017/12/26.
 */
public class StreamTokenizerExample {

    public static void main(String[] args) {
        String fileName = "D:/work/text4.txt";
        StreamTokenizerExample.statis(fileName);
    }

    public static long statis(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));

            st.ordinaryChar('\'');
            st.ordinaryChar('\"');
            st.ordinaryChar('/');

            String s;
            int numberSum = 0;
            int wordSum = 0;
            int symbolSum = 0;
            int total = 0;

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                switch (st.ttype) {
                    case StreamTokenizer.TT_EOF:
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        s = String.valueOf(st.nval);
                        System.out.println("数字有：" + s);
                        numberSum ++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = st.sval;
                        System.out.println("单词有：" + s);
                        wordSum ++;
                        break;
                    default:
                        s = String.valueOf((char) st.ttype);
                        System.out.println("标点有：" + s);
                        symbolSum ++;
                }
            }
            System.out.println("数字有 " + numberSum+"个");
            System.out.println("单词有 " + wordSum+"个");
            System.out.println("标点符号有： " + symbolSum+"个");
            total = symbolSum + numberSum +wordSum;
            System.out.println("Total = " + total);
            return total;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
