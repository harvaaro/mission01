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
	protected Node<E> head = null;

	// Tail node for the List
	protected Node<E> tail = null;

	// Count of the nodes in the List
	protected int size = 0;

	private boolean checkElement(E element) {
	    // may eventually throw an error or some message
        // but currently am just doing an error check
	    return (element != null) ? true : false;
    }

    private boolean checkIndex(int index) {
	    return (index <= size && index > 0) ? true : false;
    }

	@Override
	public E first() {
	    return head.getData();
	}

	@Override
	public E last() {
		return tail.getData();
	}

	@Override
	public void addLast(E element) {
	    // check if the element is not null
        if (checkElement(element)) {
            // create the new node
            Node<E> lastNode = new Node<>(element);

            // set its next to be the next of the tail
            lastNode.setNext(tail.getNext());

            // make the original tail next to the tail to be
            tail.setNext(lastNode);

            // change the tail to the new node
            tail = lastNode;

        }
	}

	@Override
	public void addFirst(E element) {
        // check if the element is not null
	    if (checkElement(element)) {
            // create the new node
	        Node<E> firstNode = new Node<>(element);

	        // make the next of the new node to the original head
	        firstNode.setNext(head);

	        // change the head to the new node
	        head = firstNode;
        }
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
	    // if the index and element is a usable value and not null respectively
	    if (checkIndex(index) && checkElement(element)) {
        }
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
