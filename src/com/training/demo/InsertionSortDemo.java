package com.training.demo;

public class InsertionSortDemo {

    public void insertionSort(int A[], int n) {
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int position = i;
            while (position > 0 && A[position-1] > temp) {
                A[position] = A[position-1];
                position = position -1;
            }
            A[position] = temp;
        }
    }

    public void display(int A[], int n){
        for (int i = 0; i < n; i++) {
            System.out.println(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSortDemo s = new InsertionSortDemo();
        int A[] = {3,5,8,9,6,2};
        System.out.println("Original ArrayDemo: ");
        s.display(A, 6);
        s.insertionSort(A, 6);
        System.out.println("Sorted ArrayDemo:");
        s.display(A, 6);
    }
}
