package com.training.demo;

public class StacksArray {
    private int data[];
    private int top;

    public StacksArray(int n) {
        data = new int[n];
        top = 0;
    }

    public int length() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == data.length;
    }

    public void push(int e) {
        if(isFull()) {
            System.out.println("Stack is Full/Overflow");
            return;
        }
        else {
            data[top] = e;
            top = top + 1;
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty/Underflow");
            return -1;
        }
        int e = data[top-1];
        top = top - 1;
        return e;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return data[top-1];
    }

    public void display() {
        for(int i=0; i<top; i++)
            System.out.print(data[i] + "--");
        System.out.println();
    }

    public static void main(String args[]) {
        StacksArray s = new StacksArray(10);
        s.push(5);
        s.push(3);
        s.display();
        System.out.println("Size: " + s.length());
        System.out.println("Element Popped: "+s.pop());
        System.out.println("IsEmpty: " + s.isEmpty());
        System.out.println("Element Popped: "+s.pop());
        System.out.println("IsEmpty: " + s.isEmpty());
        s.push(7);
        s.push(9);
        s.display();
        System.out.println("Element Top: "+s.peek());
        s.display();
    }
}
