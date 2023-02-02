package com.gmail.maxenamiro;

//import org.junit.Test.java;

public class TestClass {
    @Test(a=2, b=5)
    public static void test(int a, int b){
        System.out.println(a + b);
    }
    @Test(a=2, b=5)
    public static void test2(int a, int b){
        int res = a*b;
        System.out.println(res);
    }
}
