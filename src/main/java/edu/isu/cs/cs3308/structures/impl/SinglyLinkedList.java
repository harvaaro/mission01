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
	    return (index < size && index >= 0) ? true : false;
    }

    private Node<E> getNode(int index) {
		// get current head node to start from
		Node<E> seekNode = head;

		// seek through the list starting from the head
		for (int i = 0; i < index; i++) {
			//TODO
		}
	}

	private void addSize() {
		size++;
	}

	private void subSize() {
		size--;

		if (size < 0) {
			size = 0;
		}
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

            // incrememnt size
			addSize();
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

			// incrememnt size
			addSize();
        }
	}

	@Override
	public E removeFirst() {
		// keep track of the original head
		Node<E> removeNode = head;

		// decrement size
		subSize();

		//TODO

		// return the original head data
		return removeNode.getData();
	}

	@Override
	public E removeLast() {
		// keep track of the original tail
		Node<E> removeNode = tail;

		// decrement size
		subSize();

		//TODO

		// return the original tail data
		return removeNode.getData();
	}

	@Override
	public void insert(E element, int index) {
	    // if the index and element is a usable value and not null respectively
	    if (checkIndex(index) && checkElement(element)) {
			// incrememnt size
			addSize();

			// if the index is the head
			if (index == 0) {
				addFirst(element);
			}

			// else if the index is the tail
			else if (index == size-1) {
				addLast(element);
			}

			// else the index is some other node
			else {
				//TODO
			}
        }
	}

	@Override
	public E remove(int index) {
		// check if the index is a usable value
		if (checkIndex(index)) {
			// decrement size
			subSize();

			// if the index is the head
			if (index == 0) {
				return removeFirst();
			}

			// else if the index is the tail
			else if (index == size-1) {
				return removeLast();
			}

			// else the index is some other node
			else {
				//TODO
				return null;
			}
		}

		// if the index is invalid
		else {
			return null;
		}
	}

	@Override
	public E get(int index) {
		// check if the index is a usable value
		if (checkIndex(index)) {
			// if the index is the head
			if (index == 0) {
				return head.getData();
			}

			// else if the index is the tail
			else if (index == size-1) {
				return tail.getData();
			}

			// else the index is some other node
			else {
				return getNode(index).getData();
			}
		}

		// if the index is invalid
		else {
			return null;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		//TODO
		return false;
	}

	@Override
	public void printList() {
		//TODO
	}
}
