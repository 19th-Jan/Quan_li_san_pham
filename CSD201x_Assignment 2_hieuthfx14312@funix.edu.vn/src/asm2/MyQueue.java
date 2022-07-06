package asm2;

/**
* Generic version of the Queue class.
*
* @param <T> the type of the value
*/
class MyQueue<T> {

	/**
	 * Head node contains front node in the queue
	 */
	Node<T> head;
	
	/**
	 * Tail node contains last node in the queue
	 */
	Node<T> tail;
	
	/**
	 * Insert an item to the tail of this queue
	 *
	 * @param item The item to be inserted
	 */
	public void push(T item)
    {
 
        // Create a new LL node
        Node temp = new Node(item);
 
        // If queue is empty, then new node is front and rear both
        if (tail == null) {
            head = tail = temp;
            return;
        }
 
        // Add the new node at the end of queue and change rear
        tail.next = temp;
        tail = temp;
    }
}