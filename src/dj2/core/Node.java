package dj2.core;
/**
 * The Node that makes elements which the linked list is made of
 * @author Salah Eddine Azekour
 *
 * @param <T> It is any type that extends methods from Performable
 */
public class Node<T extends Performable> {

	protected T node;
	protected Node<T> next;
	protected Node<T> previous;
	/**
	 * The class takes a node date, to create a node
	 * @param node the piece that is considerd an element in a linked list
	 */
	public Node (T node) {
		this.node = node;
		next = previous = null;
	}
	/**
	 * Overrides the Object class toString() to display the contents of a Node
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		return node.toString();
	}
	/**
	 * Plays the node
	 */
	public void play() {
		node.play();
	}
	/**
	 * Returns the title back to the user
	 */
	public String getTitle() {
		return node.getTitle();
	}
	public T getNode() {
		return node;
	}
	public Node<T> getNext() {
		return next;
	}
}
