// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package carDealership;

/**
 * The menu enum represents the options available in the car dealership menu.
 * It provides the menu items and their corresponding numbers.
 */
public enum menu {
    EMPLOYEES_LIST("1. Show employees list."),
    AVAILABLE_CARS("2. Show cars available."),
    CAR_SALE("3. Car sale."),
    NEW_CAR_ADDING("4. Add new car to the agency."),
    END_PROGRAM("5. End the program.");

    private final String menu;

    /**
     * Constructs a menu item with the specified menu text.
     *
     * @param menu the text of the menu item
     */
    menu(String menu) {
        this.menu = menu;
    }

    /**
     * Returns the text of the menu item.
     *
     * @return the text of the menu item
     */
    public String getMenu() {
        return menu;
    }
}