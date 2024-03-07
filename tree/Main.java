
package com.mycompany.tree;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.push(2);
        tree.push(10);
        tree.push(4);
        tree.push(11);
        tree.push(7);

        System.out.println("Árbol ordenado de menor a mayor:");
        tree.Orden();

        System.out.println("\n\n Árbol visual:");
        tree.printTree();
    }
}

