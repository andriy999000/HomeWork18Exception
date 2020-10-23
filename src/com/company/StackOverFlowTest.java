package com.company;

public class StackOverFlowTest {
    private static int count;

    public static void test(){
        count++;
        test();
    }
}
