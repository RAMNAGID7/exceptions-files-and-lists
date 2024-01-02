// Assignment: 5
// Author: Ram Nagid, ID: 318692779
package doublyLinkedList;

import java.util.Scanner;

/**
 * The Main class contains the main method to run the program and interact with the DoublyLinkedList.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Select a number from the menu: ");
            for (listMenu main : listMenu.values()) {
                System.out.println(main.getMenu());
            }
            int selection = in.nextInt();
            if (selection - 1 > listMenu.values().length) {
                throw new Exception("Choose a number from the options at the menu.");
            }
            switch (listMenu.values()[selection - 1]) {
                case ONE -> System.out.println("The list is empty? " + list.isEmpty());
                case TWO -> System.out.println("The size of the list is: " + list.size());
                case THREE -> {
                    System.out.println("Enter a number to add to top of the list: ");
                    int data = in.nextInt();
                    list.addFirst(data);
                }
                case FOUR -> {
                    System.out.println("Enter a number to add to end of the list: ");
                    int data = in.nextInt();
                    list.addLast(data);
                }
                case FIVE -> {
                    System.out.println("Enter a number to remove from the list:");
                    int data = in.nextInt();
                    System.out.println(list.remove(data));
                }
                case SIX -> list.clear();
                case SEVEN -> {
                    System.out.println("Enter a number to check if he's in the list: ");
                    int data = in.nextInt();
                    System.out.println(list.contains(data));
                }
                case EIGHT -> list.printForward();
                case NINE -> list.printBackward();
                case TEN -> {
                    System.out.println("The end!");
                    return;
                }
                default -> System.out.println("no option");
            }
        }
    }
}
