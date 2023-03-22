package com.seungho;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            BigList bigList = new BigList(new File("list.seq"));
            for (int i = 0; i < 100000000; i++) {
                bigList.add(i);
            }
            System.out.println(bigList.get(12345678));
            bigList.flush();
            bigList.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
