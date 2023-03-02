package com.training.demo;

public class DoublyLinkedList {
    class Node {
        int element;
        Node next;
        Node prev;
        public Node(int e, Node n, Node p)
        {
            element = e;
            next = n;
            prev = p;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(int e) {
        Node newest = new Node(e, null, null);
        if(isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            tail.next = newest;
            newest.prev = tail;
            tail = newest;
        }
        size = size + 1;
    }

    public void addFirst(int e) {
        Node newest = new Node(e, null, null);
        if(isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            newest.next = head;
            head.prev = newest;
            head = newest;
        }
        size = size + 1;
    }

    public void addAny(int e, int position) {
        if(position <= 0 || position >= size) {
            System.out.println("Invalid Position");
            return;
        }
        Node newest = new Node(e, null, null);
        Node p = head;
        int i = 1;
        while(i < position-1) {
            p = p.next;
            i = i + 1;
        }
        newest.next = p.next;
        p.next.prev = newest;
        p.next = newest;
        newest.prev = p;
        size = size + 1;
    }

    public int removeFirst() {
        if(isEmpty()) {
            System.out.println("Doubly List is Empty");
            return -1;
        }
        int e = head.element;
        head = head.next;
        size = size - 1;
        if(isEmpty())
            tail = null;
        else
            head.prev = null;
        return e;
    }

    public int removeLast() {
        if(isEmpty()) {
            System.out.println("Doubly List is Empty");
            return -1;
        }
        int e = tail.element;
        tail = tail.prev;
        tail.next = null;
        size = size - 1;
        return e;
    }

    public int removeAny(int position) {
        if(position <= 0 || position >= size-1) {
            System.out.println("Invalid Position");
            return -1;
        }
        Node p = head;
        int i = 1;
        while(i < position-1) {
            p = p.next;
            i = i + 1;
        }
        int e = p.next.element;
        p.next = p.next.next;
        p.next.prev = p;
        size = size - 1;
        return e;
    }

    public void display() {
        Node p = head;
        while(p!=null) {
            System.out.print(p.element + "-->");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DoublyLinkedList l = new DoublyLinkedList();
        l.addLast(7);
        l.addLast(4);
        l.addLast(12);
        l.addLast(8);
        l.addLast(3);
        l.display();
        System.out.println("Size: " + l.length());
        int element = l.removeAny(3);
        System.out.println("Removed Element: " + element);
        l.display();
        System.out.println("Size: " + l.length());

    }
}
