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

    private void singleHeadTail(Node<E> theNode) {
		if (size == 1) {
			head = theNode;
			tail = theNode;
		}
		else if (size == 0) {
			head = null;
			tail = null;
		}
	}

    private Node<E> getNode(int index) {
		// get current head node to start from
		Node<E> seekNode = head;

		// seek through the list starting from the head
		for (int i = 0; i < index; i++) {
			seekNode = seekNode.getNext();
		}

		// return the desired Node from the list index
		return seekNode;
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
	    return (head != null) ? head.getData() : null;
	}

	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	@Override
	public void addLast(E element) {
	    // check if the element is not null
        if (checkElement(element)) {
        	// check if the size is at least 1
        	if (!isEmpty()) {
				// create the new node
				Node<E> lastNode = new Node<>(element);

				// set its next to be null
				lastNode.setNext(null);

				// make the original tail next to the tail to be
				tail.setNext(lastNode);

				// change the tail to the new node
				tail = lastNode;

				// incrememnt size
				addSize();
			}
        	// else if size is 0 just add first
        	else {
        		addFirst(element);
			}
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

			// fix the head and tail if single node in list
			singleHeadTail(firstNode);
        }
	}

	@Override
	public E removeFirst() {
		// if the head Node is not null
		if (head != null) {

			// keep track of the original head
			Node<E> removeNode = head;

			// set the new head to next of original
			head = removeNode.getNext();

			// remove next of original head
			removeNode.setNext(null);

			// decrement size
			subSize();

			// fix the head and tail if single node in list
			singleHeadTail(head);

			// return the original head data
			return removeNode.getData();
		}

		// else there is no head Node
		else {
			return null;
		}
	}

	@Override
	public E removeLast() {
		// because of how remove works, check if there are at least 2 nodes
		if (size > 1) {
			return remove(size - 1);
		}

		// else just remove the first node
		else {
			return removeFirst();
		}
	}

	@Override
	public void insert(E element, int index) {
	    // if the element is not null
	    if (checkElement(element)) {
			// if the index is the head
			if (index == 0) {
				addFirst(element);
			}

			// else if the index is the tail
			else if (index >= size) {
				addLast(element);
			}

			// else the index is some other node
			else {
				// check if the index is a usable value
				if (checkIndex(index)) {
					// get the node before the one to be added
					Node<E> prevNode = getNode(index-1);

					// create the node to be inserted
					Node<E> insertNode = new Node<>(element);

					// set the correct next for the new node
					insertNode.setNext(prevNode.getNext());

					// set the correct next for the previous node
					prevNode.setNext(insertNode);

					// incrememnt size
					addSize();
				}
			}
        }
	}

	@Override
	public E remove(int index) {
		// check if the index is a usable value
		if (checkIndex(index)) {
			// if the index is the head
			if (index == 0) {
				return removeFirst();
			}

			// else the index is some other node
			else {
				// get the node before the one to be removed
				Node<E> prevNode = getNode(index-1);

				// get the node that will be removed
				Node<E> removeNode = prevNode.getNext();

				// set the new connection with the node removed
				prevNode.setNext(removeNode.getNext());

				// null out the next of the removeNode
				removeNode.setNext(null);

				// decrement size
				subSize();

				// fix the head and tail if single node in list
				singleHeadTail(prevNode);

				// return the removed Node data
				return removeNode.getData();
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
		return (size == 0) ? true : false;
	}

	@Override
	public void printList() {
		//TODO
	}
}
