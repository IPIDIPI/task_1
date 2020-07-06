package com.ipidipi;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTree {

    Node root;

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node addRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = addRecursive(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addRecursive(currentNode.right, value);
        } else {
            return currentNode;
        }
        return currentNode;
    }

    public int add(int value) {
        root = addRecursive(root, value);
        return value;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    @Test
    public void givenABinaryTree__WhenAddingElements__ThenTreeContainsThoseElements() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(8);
        bt.add(4);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));
        assertFalse(bt.containsNode(1));
    }

}

