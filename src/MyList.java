
/**
 * Generic version of the LinkedList class.
 *
 * @param <T> the type of the value
 */
public class MyList<T> {

    /**
     * Head node, default is null
     */
    Node<T> head;

    /**
     * Tail node, default is null
     */
    Node<T> tail;

    /**
     * Default constructor
     */
    public MyList() {
        head = tail = null;
    }

    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return this.head == null;
    }


    /**
     * Returning the length of this list
     *
     * @return The length of this list
     */
    public int length() {
        if (isEmpty())
            return 0;
        int length = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            length += 1;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Insert an item to the head of this list
     *
     * @param item The item to be inserted
     */
    public void insertToHead(T item) {
        Node<T> newNode = new Node<>(item, this.head);
        this.head = newNode;
    }

    /**
     * Insert an item at position to this list
     *
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        if (position < 0) {
            return;
        }
        // If position is zero, It's add to first
        if (position == 0) {
            this.insertToHead(item);
            return;
        }
        int i = 0;
        Node<T> cur = this.head;
        while (i < position - 1 && cur != null) {
            i++;
            cur = cur.next;
        }
        // position is outIndex of linked list
        if (i != position - 1) {
            return;
        }
        // insert newNode to position
        Node<T> newNode = new Node<>(item, cur.next);
        cur.next = newNode;
    }

    /**
     * Deleting the tail of this list
     */
    public void deleteTail() {
        if (isEmpty())
            throw new RuntimeException("Empty linked list!");
        tail = tail.next;

        if (isEmpty())
            head = null;
        else
            tail.next = null;
    }

    /**
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * @param item The item to be deleted
     */
    public void deleteElement(T item) {
         // Store head node
        Node<T> temp = head, prev = null;
 
        if (temp != null && temp.info == item) {
            head = temp.next; // Changed head
            return;
        }
 
        while (temp != null && temp.info != item) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
         
    }

    /**
     * Swaping two nodes [firstNode] and [secondNode]
     *
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T temp;
        temp = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = temp;
    }

    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = tail = null;
    }

    public Node<T> getNode(int i) {
        Node<T> p = head; 
        int count = 0;
        while(count < i) {
            p = p.next;
            count++;
        }
        return p;
    }

}
