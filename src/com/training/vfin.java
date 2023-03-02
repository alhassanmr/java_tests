package com.training;

public class vfin {
    public static void main(String[] args) {
        int[] intArray = new int[]{ 1,2};
        int sum = 0;
        for (int item: intArray){
            sum += item;
        }
        System.out.println("sum"+sum);
    }
}
