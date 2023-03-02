package com.training.demo;

public class BubbleSortDemo {

    public void bubblesort(int A[], int n) {
        for (int pass = n-1; pass >=0 ; pass--) {
            for (int i = 0; i < pass; i++) {
                if (A[i] > A[i+1]) {
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
    }

    public void display(int A[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSortDemo b = new BubbleSortDemo();
        int A[] = {3,5,8,9,6,2};
        System.out.println("original ArrayDemo:");
        b.display(A,6);
        b.bubblesort(A,6);
        System.out.println("Sorted ArrayDemo:");
        b.display(A,6);
    }
}
