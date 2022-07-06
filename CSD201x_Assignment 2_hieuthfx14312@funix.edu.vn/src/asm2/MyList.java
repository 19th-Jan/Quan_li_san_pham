package asm2;

/**
* Generic version of the LinkedList class.
*
* @param <T> the type of the value
*/
public class MyList<T> {

	/**
	 * Head node, default is null
	 */
	Node<T> head = null;

	/**
	 * Tail node, default is null
	 */
	Node<T> tail = null;
	
	/**
	 * Default constructor
	 */
	public MyList() {

	}

	/**
	 * Constructor with head and tail
	 *
	 * @param head Head node of this list
	 * @param tail Tail node of this list
	 */
	public MyList(Node head, Node tail) {

	}

	/**
	 * Checking if this list is empty
	 *
	 * @return true if list is empty
	 */
	public boolean isEmpty() {
		return length() == 0;
	}

	/**
	 * Returning the length of this list
	 *
	 * @return The length of this list
	 */
	public int length() {
		Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
	}

	/**
	 * Insert an item to the head of this list
	 *
	 * @param item The item to be inserted
	 */
	public void insertToHead(T item ) {
		 Node newNode = new Node(item);
		 	newNode.next = this.head;
	        this.head = newNode;
	}
	
	/**
	 * Insert an item to the tail of this list
	 *
	 * @param item The item to be inserted
	 */
	public void insertToTail(T item) {
		Node newNode = new Node(item);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	/**
	 * Insert an item at position to this list
	 *
	 * @param position The position of new item
	 * @param item     The item to be inserted
	 */
	public void insertAfterPosition(int position, T item) {
		Node head = this.head;
        if (position < 1)
            System.out.print("Invalid position");
 
        // if position is 1 then new node is
        // set infornt of head node
        // head node is changing.
        if (position == 1) {
            Node newNode = new Node(item);
            newNode.next = this.head;
            this.head = newNode;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    // adding Node at required position
                    Node newNode = new Node(item);
 
                    // Making the new Node to point to
                    // the old Node at the same position
                    newNode.next = head.next;
 
                    // Replacing current with new Node
                    // to the old Node to point to the new Node
                    head.next = newNode;
                    break;
                }
                head = head.next;
            }
            if (position != 1)
                System.out.print("Position out of range");
        }
	}

	/**
	 * Deleting the tail of this list
	 */
	public void deleteTail() {
		
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;
        
        second_last.next = null;
	}

	/**
	 * Deleting all items in the list
	 */
	public void clear() {
		head = tail = null;
	}
}
