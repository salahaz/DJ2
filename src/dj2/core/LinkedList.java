package dj2.core;
/**
 * Implements a doubly linked list, with the typical linked list method, and playing the linkedlist.
 * @author Salah Eddine Azekour
 */
public class LinkedList<T extends Performable>{
	Node<T> head, last;
	int numberOfElements;
	/**
	 * The class doesn't take any arguments, the linked list created by just calling it
	 */
	public LinkedList(){
		head = last = null;
		numberOfElements = 0;
	}
	/**
	 * Adds a node to the linked list
	 * @param node the node that is going to be added to the linked list
	 */
	public void add(T node){
		Node<T> newNode = new Node<T>(node);
		if (head == null)
			head = last = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}
		numberOfElements++;
	}
	/**
	 * Deletes a node in the linked list
	 * @param node the node to be delted from the linked list
	 */
	public void delete(T node){
		Node<T> nodePosition = search(node);
		if(head == nodePosition)
			head = head.next;
		if (nodePosition.next != null)
			nodePosition.next.previous = nodePosition.previous;
		
		if (nodePosition.previous != null)
				nodePosition.previous = nodePosition.previous;
	}
	/**
	 * Returns the number of nodes in the linked list
	 * @return {int} number of nodes 
	 */
	public int getCount(){
		return numberOfElements;
	}
	/**
	 * Searches throughtout the list for the specified node
	 * @param node node to look for
	 * @return returns the node of the found data
	 */
	public Node<T> search(T node){
		for(Node<T> walker = head; walker != null; walker = walker.next)
			if(walker.node == node)
				return walker;
		return null;
	}
    public T get(int index){
        if(index < 0 || index >= numberOfElements)
            throw new ArrayIndexOutOfBoundsException(index);
        Node<T> walker = head;
        int i = 0;
        for(; walker != null && i < index; walker = walker.next){
        	i++;
        }
        return walker.node;
    }
	public T searchByTitle(String title){
		Node<T> walker;
		for(walker = head; walker != null; walker = walker.next)
			if(walker.node.getTitle() == title)
				return walker.node;
		return null;
	}
	/**
	 * plays the entire playlsit
	 */
	public void playList() {
		for(Node<T> walker = head; walker != null; walker = walker.next)
			walker.node.play();
	}
	public Node<T> getHead() {
		return head;
	}
    public Object[] toArray() {
        if(numberOfElements == 0)
            return null;
        Object[] objects = new Object[numberOfElements];
        int index = 0;
        for(Node<T> walker = head; walker != null; walker = walker.next)
            objects[index++] = walker.node;
        return objects;
    }
	/**
	 * Overrides the Object super class's toString(), to display infromation relevant to a linked list
	 *
	 * @return {String} The information to be returned back to the user
	 */
	public String toString() {
		StringBuffer info = new StringBuffer();
		for (Node<T> walker = head; walker != null; walker = walker.next)
			info.append(walker.node.toString());
		return info.toString();
	}
}
