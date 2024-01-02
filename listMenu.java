// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package doublyLinkedList;


/**
 * The listMenu enum represents the menu options for interacting with a list.
 * Each menu option has a corresponding number and description.
 */
public enum listMenu {
    ONE("1.Checks if the list is empty."),
    TWO("2.Checks the size of the list."),
    THREE("3.Adds an object to the head of the list."),
    FOUR("4.Adds an object to the bottom of the list."),
    FIVE("5.Removes the head object if he is the same as the input object."),
    SIX("6.Clears the list."),
    SEVEN("7.Checks if the object is exist in the list."),
    EIGHT("8.Prints the list from head to tail."),
    NINE("9.Prints the list from tail to head."),
    TEN("10.Press to end the program.");

    private final String listMenu;

    listMenu(String s) {
        this.listMenu = s;
    }

    public String getMenu() {
        return listMenu;
    }
}
