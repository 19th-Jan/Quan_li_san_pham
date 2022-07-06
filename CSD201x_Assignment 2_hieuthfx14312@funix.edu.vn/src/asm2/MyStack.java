package asm2;

/**
* Generic version of the Stack class.
*
* @param <T> the type of the value
*/
class MyStack<T> {

	/**
	 * Head node contains front node in the stack
	 */
	Node<T> head;
	
	
	/**
	 * Insert an item to the head of this stack
	 *
	 * @param item The item to be inserted
	 */
	public void push(T item) {
		Node temp = new Node(item);
	 
	    if (temp == null) {
	    	return;
	    }

	    temp.next = head;
	    head = temp;
	    }
}
