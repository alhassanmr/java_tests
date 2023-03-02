package com.training.demo;

public class LinkedList {
    class Node {
        int element;
        Node next;
        public Node(int e, Node n) {
            element = e;
            next = n;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
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

    public void addlast(int e) {
        Node newest = new Node(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.next = newest;
        tail = newest;
        size = size + 1;
    }

    public void addFirst(int e) {
        Node newest = new Node(e, null);
        if(isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            newest.next = head;
            head = newest;
        }
        size = size + 1;
    }

    public int search(int key) {
        Node p = head;
        int index = 0;
        while(p!=null) {
            if(p.element==key)
                return index;
            p = p.next;
            index = index + 1;
        }
        return -1;
    }

    public void addAny(int e, int position) {
        if(position < 0 || position > size) {
            System.out.println("Invalid Position");
            return;
        }
        if(position==0) {
            addFirst(e);
            return;
        }
        else {
            Node newest = new Node(e, null);
            Node p = head;
            int i = 0;
            while (i < position - 1) {
                p = p.next;
                i = i + 1;
            }
            newest.next = p.next;
            p.next = newest;
        }
        size = size + 1;
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
        LinkedList l = new LinkedList();
        l.addlast(7);
        l.addlast(4);
        l.addlast(12);
        l.addlast(8);
        l.addlast(3);
        l.display();
        System.out.println("Size: "+l.length());
        l.addFirst(15);
        l.display();
        System.out.println("Size: "+l.length());
        l.addFirst(25);
        l.display();
        System.out.println("Size: "+l.length());
    }

}
