import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String menuChoice;
        String[] list = new String[100];
        int numOfItems  = 1;
        do {

            System.out.println("Please choose an option from the following: ");
            System.out.println("A - Add an item to list  ");
            System.out.println("D - Delete item in list  ");
            System.out.println("I - Insert item into list");
            System.out.println("P - Print the list       ");
            System.out.println("Q - Quit the program     ");
            menuChoice = in.nextLine().toUpperCase();

            if (menuChoice.equals("A")) {
                System.out.println("Enter the name of the item you want to add: ");
                String itemName = in.nextLine();
                list[numOfItems] = itemName;
                numOfItems++;

            } else if (menuChoice.equals("D")) {
                System.out.println("Enter the number of the item you want to delete: ");
                int itemNum = Integer.parseInt(in.nextLine());
                if (itemNum < 1 || itemNum > numOfItems) {
                    System.out.println("Invalid input. Please try again.");
                } else {
                    int index = itemNum - 1;

                    for (int i = index; i < numOfItems - 1; i++) {
                        list[i] = list[i + 1];
                        numOfItems--;
                        System.out.println("Item deleted.");
                    }
                }


            } else if (menuChoice.equals("I")) {
                System.out.println("Enter the position of the item you want to insert: ");
                int position = Integer.parseInt(in.nextLine());

                if (position < 1 || position > numOfItems + 1) {
                    System.out.println("Invalid position. Please try again.");
                } else {
                    System.out.println("Enter the name of the item you want to insert:");
                    String itemName = in.nextLine();
                    int index = position - 1;
                    for (int i = numOfItems; i > index; i--) {
                        list[i] = list[i - 1];
                        list[index] = itemName;
                        System.out.println("Item inserted.");
                        numOfItems++;
                    }
                }

            } else if (menuChoice.equals("P")) {
                System.out.println("The list of items:  ");

                if (numOfItems == 0) {
                    System.out.println("There are no items in the list");
                } else {
                    for (int i = 0; i < numOfItems; i++) {
                        System.out.println((i + 1) + ". " + list[i]);
                    }
                }
            }
            if (menuChoice.equals("Q")) {
                System.out.println("Are you sure you would like to quit the program? (y/n)");
                String answer = in.nextLine().toLowerCase();
                if (answer.equals("y")) {
                    System.out.println("Quitting the program.");
                } else if (answer.equals("n")) {
                    System.out.println("Returning to program.");
                    menuChoice = "";
                }
            }
        } while (!menuChoice.equals("Q"));
    }
}