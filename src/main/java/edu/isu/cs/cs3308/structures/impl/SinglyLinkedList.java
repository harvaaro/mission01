package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * A class to implement a singly linked list based off the List class
 *
 * @author Aaron Harvey
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E> {

    // Head node for the List
    protected Node<E> head;

    // Tail node for the List
    protected Node<E> tail;

    // Count of the nodes in the List
    protected int size = 0;

    @Override
    public E first() {
        return null;
    }

    @Override
    public E last() {
        return null;
    }

    @Override
    public void addLast(E element) {

    }

    @Override
    public void addFirst(E element) {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public void insert(E element, int index) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void printList() {

    }
}
