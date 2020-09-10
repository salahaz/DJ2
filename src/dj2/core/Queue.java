package dj2.core;
/**
 * Implements a Queue using a doubly linked list, with its typical methods
 * @author Salah Eddine Azekour
 */
public class Queue<T extends Performable> extends LinkedList<T> {
	private static final int MAX_NUMBER = 12;
	/**
	 * The class doesn't take any arguments, the queue gets created by just calling it
	 */
	public Queue() {
		super();
	}
	/**
	 * Adds a node to the beginnning of the queue
	 */
	public void add(T node) {
		Node<T> newNode= new Node<T>(node);

		newNode.previous = null;
		if (numberOfElements == MAX_NUMBER)
				delete();
		if(head == null)
			head = last = newNode;
		else {
			newNode.next = head;
			if(head != null)
				head.previous = newNode;
			head = newNode;
		}
		numberOfElements++;
	}
	/**
	 * Delets a node from the end of a queue
	 */
	private void delete() {
		Node<T> lastNode = last;
		last = last.previous;
		last.next = null;
		lastNode.next = lastNode.previous = null;
		lastNode = null;
		numberOfElements--;
	}
}
