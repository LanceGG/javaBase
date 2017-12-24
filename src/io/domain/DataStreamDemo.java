package io.domain;

import java.io.*;

/**
 * Created by Lance on 2017/12/25.
 */
public class DataStreamDemo {

    public static void main(String[] args) {
        Member[] members = {new Member("Justin",90),
                new Member("momor",95),
                new Member("Bush",88)};
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("D:/work/member.txt"));
            for (Member member: members) {
                dataOutputStream.writeUTF(member.getName());
                dataOutputStream.writeInt(member.getAge());
            }
            dataOutputStream.flush();
            dataOutputStream.close();

            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:/work/member.txt"));
            for(int i = 0; i < members.length; i++) {
                String name = dataInputStream.readUTF();
                int score = dataInputStream.readInt();
                members[i] = new Member(name, score);
            }
            dataInputStream.close();
            for(Member member: members) {
                System.out.println(member);
            }
        }catch (IOException e) {

        }
    }
}
