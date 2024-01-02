// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package doublyLinkedList;

/**
 * The List interface defines the operations that can be performed on a list data structure.
 * <p>
 * It provides methods to manipulate and access the elements of the list.
 *
 * @param <T> the type of elements stored in the list
 */
public interface List<T> {
    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size();

    /**
     * Adds an element at the beginning of the list.
     *
     * @param data the element to be added
     */
    public void addFirst(T data);

    /**
     * Adds an element at the end of the list.
     *
     * @param data the element to be added
     */
    public void addLast(T data);

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param data the element to be removed
     * @return the removed element, or null if the element is not found
     */
    public T remove(T data);

    /**
     * Removes all elements from the list, making it empty.
     */
    public void clear();

    /**
     * Checks if the list contains the specified element.
     *
     * @param data the element to be checked
     * @return true if the list contains the element, false otherwise
     */
    public boolean contains(T data);

    /**
     * Prints the elements of the list in forward order.
     */
    public void printForward();

    /**
     * Prints the elements of the list in backward order.
     */
    public void printBackward();
}
