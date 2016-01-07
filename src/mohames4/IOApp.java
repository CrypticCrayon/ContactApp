/*
 Shanaz Mohamed
 IOAppContactBook- This project creates a contact book and save them to a files in the system 
 and loads the files from the system by printing back the content of the file.
 */

package mohames4;

import java.util.Scanner;

/**
 *
 * This class is the driver class for this program. 
 * Lists options for user to choose from and calls the appropriate class methods based on the user input.
 */
public class IOApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String choice;
        ContactBook book = new ContactBook();

        do {
            System.out.println();
            System.out.println("1) List All Contacts");
            System.out.println("2) Add a Contact");
            System.out.println("3) Update a Contact");
            System.out.println("4) Remove a Contact");
            System.out.println("5) Save Contact Book");
            System.out.println("6) Load a Contact Book");
            System.out.println("7) Exit");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println(book);
                    break;
                case "2":
                    book.add(sc);
                    break;
                case "3":
                    book.update(sc);
                    break;
                case "4":
                    book.remove(sc);
                    break;
                case "5":
                    book.save(sc);
                    break;
                case "6":
                    book.load(sc);
                    break;
            }
        } while (!choice.equalsIgnoreCase("7"));
    }

}
