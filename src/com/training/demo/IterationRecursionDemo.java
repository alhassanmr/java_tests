package com.training.demo;

public class IterationRecursionDemo {

    public void calculateIterative(int n) {
        while ( n > 0) {
            int k = n * n;
            System.out.print(k);
            n = n - 1;
        }
    }

    public void calculateRecursive(int n) {
        if ( n > 0) {
            int k = n * n;
            System.out.println(k);
            calculateRecursive(n - 1);
        }
    }

    public static void main(String[] args) {
        IterationRecursionDemo r = new IterationRecursionDemo();
//        r.calculateIterative(4);
        r.calculateRecursive(4);
    }
}
