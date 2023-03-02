package com.training.demo;

public class BinarySearchTree {

    public class Node {
        int element;
        Node left;
        Node right;

        public Node(int e, Node l, Node r) {
            element = e;
            left = l;
            right = r;
        }
    }

    Node root;
    public BinarySearchTree() {
        root = null;
    }

    public void insert(Node temproot, int e) {
        Node temp = null;
        while(temproot!=null) {
            temp = temproot;
            if(e==temproot.element)
                return;
            else if(e < temproot.element)
                temproot = temproot.left;
            else if(e > temproot.element)
                temproot = temproot.right;
        }
        Node n = new Node(e,null,null);
        if(root!=null)
            if(e < temp.element)
                temp.left = n;
            else
                temp.right = n;
        else
            root = n;
    }

    public void inorder(Node temproot) {
        if(temproot!=null) {
            inorder(temproot.left);
            System.out.print(temproot.element + " ");
            inorder(temproot.right);
        }
    }

    public void preorder(Node temproot) {
        if(temproot!=null) {
            System.out.print(temproot.element + " ");
            preorder(temproot.left);
            preorder(temproot.right);
        }
    }

    public void postorder(Node temproot) {
        if(temproot!=null) {
            postorder(temproot.left);
            postorder(temproot.right);
            System.out.print(temproot.element + " ");
        }
    }

    public boolean search(int key) {
        Node temproot = root;
        while(temproot!=null) {
            if(key== temproot.element)
                return true;
            else if(key < temproot.element)
                temproot = temproot.left;
            else if(key > temproot.element)
                temproot = temproot.right;
        }
        return false;
    }

    public int count(Node temproot) {
        if(temproot!=null) {
            int x = count(temproot.left);
            int y = count(temproot.right);
            return x + y + 1;
        }
        return 0;
    }

    public int height(Node temproot) {
        if(temproot!=null) {
            int x = height(temproot.left);
            int y = height(temproot.right);
            if(x > y)
                return x + 1;
            else
                return y + 1;
        }
        return 0;
    }

    public static void main(String args[]) {
        BinarySearchTree B = new BinarySearchTree();
        B.insert(B.root, 50);
        B.insert(B.root, 30);
        B.insert(B.root, 80);
        B.insert(B.root, 10);
        B.insert(B.root, 40);
        B.insert(B.root, 60);
        B.insert(B.root, 90);
        System.out.println("Inorder Traversal");
        B.inorder(B.root);
        System.out.println();
        System.out.println("Preorder Traversal");
        B.preorder(B.root);
        System.out.println();
        System.out.println("Postorder Traversal");
        B.postorder(B.root);
        System.out.println();
        System.out.println("Search Result: " +B.search(60));
        System.out.println("Number of Node: " + B.count(B.root));
        System.out.println("Height: " + (B.height(B.root)-1));
    }
}
