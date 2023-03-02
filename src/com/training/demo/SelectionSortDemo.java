package com.training.demo;

public class SelectionSortDemo {

    public void selectionSort(int A[], int n) {
//        iterating through the array whiles the length reduces in size
        for (int i = 0; i < n-1; i++) {
            int position = i;
            for (int j = i+1; j < n; j++) {
                if(A[j] < A[position])
                    position = j;
                int temp = A[i];
                A[i] = A[position];
                A[position] = temp;
            }
        }
    }
    public void display(int A[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSortDemo s = new SelectionSortDemo();
        int A[] = {3,5,8,9,6,2};
        System.out.println("original ArrayDemo:");
        s.display(A,6);
        s.selectionSort(A,6);
        System.out.println("Sorted ArrayDemo:");
        s.display(A,6);
    }
}
