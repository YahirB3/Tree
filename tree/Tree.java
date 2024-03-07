package com.mycompany.tree;

public class Tree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
 
    private int value;
    private boolean color;
    private Tree left;
    private Tree right;
    
    public Tree(int value) {
        this.value = value;
        this.color = RED;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return this.value;
    }

    public void push(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Tree(value);
            } else {
                left.push(value);
            }
        } else {
            if (right == null) {
                right = new Tree(value);
            } else {
                right.push(value);
            }
        }
    }
    
    public void Orden() {
        if (left != null) {
            left.Orden();
        }
        System.out.print(value + ",");
        if (right != null) {
            right.Orden();
        }
    }
    private Tree rotateLeft(Tree node) {
        Tree x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    
    private Tree rotateRight(Tree node) {
        Tree x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }
    private void flipColors(Tree node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    private boolean isRed(Tree node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    public Tree insert(int newValue) {
        return insert(this, newValue); 
    }
    private Tree insert(Tree node, int newValue) {
        if (node == null) {
            return new Tree(newValue);
        }
        if (newValue < node.value) {
            node.left = insert(node.left, newValue);
        } else if (newValue > node.value) {
            node.right = insert(node.right, newValue);
        } else {
            return node;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }
    public void printTree() {
        printTree(this, 0);
    }

    private void printTree(Tree node, int depth) {
        if (node == null) {
            return;
        }

        printTree(node.right, depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(node.value);

        printTree(node.left, depth + 1);
    }
}