package com.ipidipi;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }



    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public MyList() {

    }

    Node<E> node(int index) {

        // assert isElementIndex(index);


        Node<E> x;
        if (index < (size >> 1)) {

            x = first;

            for (int i = 0; i < index; i++)

                x = x.next;

        } else {

            x = last;

            for (int i = size - 1; i > index; i--)

                x = x.prev;

        }
        return x;

    }

    private boolean isElementIndex(int index) {

        return index >= 0 && index < size;

    }

    private boolean isPositionIndex(int index) {

        return index >= 0 && index <= size;

    }


    private String outOfBoundsMsg(int index) {

        return "Index: " + index + ", Size: " + size;

    }

    private void checkElementIndex(int index) {

        if (!isElementIndex(index))

            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

    }

    private void checkPositionIndex(int index) {

        if (!isPositionIndex(index))

            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

    }

    public E get(int index) {
        checkElementIndex(index);

        return node(index).item;
    }

    public void add(E element) {
        linkLast(element);
    }

    void linkLast(E e) {

        final Node<E> l = last;

        final Node<E> newNode = new Node<>(l, e, null);

        last = newNode;

        if (l == null)

            first = newNode;

        else

            l.next = newNode;

        size++;
    }

    void linkBefore(E e, Node<E> succ) {

        // assert succ != null;

        final Node<E> pred = succ.prev;

        final Node<E> newNode = new Node<>(pred, e, succ);

        succ.prev = newNode;

        if (pred == null)

            first = newNode;

        else

            pred.next = newNode;

        size++;

    }


    public void add(int index, E element) {

        checkPositionIndex(index);


        if (index == size)

            linkLast(element);

        else

            linkBefore(element, node(index));

    }
}

