// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package doublyLinkedList;

/**
 * The Node class represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    /**
     * Constructs a new node with the specified data.
     *
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Returns the previous node in the linked list.
     *
     * @return the previous node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Sets the previous node in the linked list.
     *
     * @param prev the previous node
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns a string representation of the node's data.
     *
     * @return a string representation of the data
     */
    @Override
    public String toString() {
        return data.toString();
    }
}