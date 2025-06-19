package Materia.controllers;

import Materia.models.Node;

public class ArbolBinario {
    private Node root;
    private int size;

    public ArbolBinario() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            size++;
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol() {
        imprimir(root);
        System.out.println();
    }

    private void imprimir(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " , ");
            imprimir(node.getLeft());
            imprimir(node.getRight());
        }
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) return false;
        if (node.getValue() == value) return true;

        if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int getSize() {
        return size;
    }

    public void printInOrderSimple() {
        printInOrderSimple(root);
        System.out.println();
    }

    private void printInOrderSimple(Node node) {
        if (node != null) {
            printInOrderSimple(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrderSimple(node.getRight());
        }
    }

    // InOrder con alturas
    public void printInOrderWithHeights() {
        printInOrderWithHeights(root);
        System.out.println();
    }

    private void printInOrderWithHeights(Node node) {
        if (node != null) {
            printInOrderWithHeights(node.getLeft());
            System.out.print(node.getValue() + " (h = " + getHeight(node) + ") ");
            printInOrderWithHeights(node.getRight());
        }
    }

    public void printInOrderWithBalance() {
        printInOrderWithBalance(root);
        System.out.println();
    }

    private void printInOrderWithBalance(Node node) {
        if (node != null) {
            printInOrderWithBalance(node.getLeft());
            System.out.print(node.getValue() + " (bf = " + getBalanceRec(node) + ") ");
            printInOrderWithBalance(node.getRight());
        }
    }

    private int getBalanceRec(Node node) {
        if (node == null) return 0;
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    public boolean estaEquilibrado() {
        return estaEquilibrado(root);
    }

    private boolean estaEquilibrado(Node node) {
        if (node == null) return true;
        int balance = getBalanceRec(node);
        if (Math.abs(balance) > 1) return false;
        return estaEquilibrado(node.getLeft()) && estaEquilibrado(node.getRight());
    }

    public void printNodosDesequilibrados() {
        printNodosDesequilibrados(root);
    }

    private void printNodosDesequilibrados(Node node) {
    if (node != null) {
        printNodosDesequilibrados(node.getLeft());
        int bf = getBalanceRec(node);
        if (Math.abs(bf) > 1) {
            System.out.println(node.getValue() + " (fE = " + bf + ")");
        }
        printNodosDesequilibrados(node.getRight());
    }
    }
}

