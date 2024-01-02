// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package doublyLinkedList;

/**
 * The DoublyLinkedList class represents a doubly linked list data structure.
 * It implements the List interface and provides methods to manipulate and access the elements of the list.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs an empty DoublyLinkedList.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element at the beginning of the list.
     *
     * @param data the element to be added
     */
    @Override
    public void addFirst(T data) {
        size++;
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param data the element to be added
     */
    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param data the element to be removed
     * @return the removed element, or null if the element is not found
     */
    @Override
    public T remove(T data) {
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return data;
        }
        Node<T> current = head.getNext();
        while (current != null) {
            if (current.getData().equals(data)) {
                current.getPrev().setNext(current);
                return data;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Removes all elements from the list, making it empty.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param data the element to be checked
     * @return true if the list contains the element, false otherwise
     */
    @Override
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (data.equals(current.getData())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Prints the elements of the list in forward order.
     */
    @Override
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current + " ");
            current = current.getNext();
        }
        System.out.println(" ");
    }

    /**
     * Prints
     * <p>
     * the elements of the list in backward order.
     */
    @Override
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current + " ");
            current = current.getPrev();
        }
        System.out.println(" ");
    }
}