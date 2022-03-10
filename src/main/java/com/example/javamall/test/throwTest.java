package com.example.javamall.test;

public class throwTest {
    static void pop() throws NegativeArraySizeException {
        int[] arr = new int[-3];
    }

    public static void main(String[] args) {
//        pop();
        try {
            pop();
        } catch (NegativeArraySizeException e) {
            System.out.println("error");
        }

//        int a = 6;
//        int b = 0;
//        try {
//            if(b == 0) throw  new ArithmeticException();
//            System.out.println(a/b);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("finally");
//        }
    }
}
