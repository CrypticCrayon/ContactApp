/*
 Shanaz Mohamed
 IOAppContactBook- This project creates a contact book and save them to a files in the system 
 and loads the files from the system by printing back the content of the file.
 */
package mohames4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is used to create a contact object, add, update, remove objects. 
 * It also has a method to save contacts to the file and load the contacts from a file in the system.
 */
public class ContactBook {

    Scanner scn = new Scanner(System.in);
    private Contact[] entries = new Contact[0];
    private final ContactFileManager fileMan = new ContactFileManager();

    public ContactBook() {
    }

    /**
     * This method lets the user add new contact object by getting input form the user
     * @param sc -takes scanner object as parameter to get input from the user
     */
    public void add(Scanner sc) {
        Contact c = new Contact();
        System.out.println("Enter a name: ");
        c.setName(sc.nextLine());
        System.out.println("Enter an address: ");
        c.setAddress(sc.nextLine());
        System.out.println("Enter a phone number: ");
        c.setPhone(sc.nextLine());
        System.out.println("Enter an email address: ");
        c.setEmail(sc.nextLine());
        entries = Arrays.copyOf(entries, entries.length + 1);
        entries[entries.length - 1] = c;
    }

    /**
     *This method updates a contact object by taking a scanner input to select the contact and updates it with new information.
     * @param sc - takes scanner object as a parameter to pick an item to update.
     */
    public void update(Scanner sc) {
        System.out.println(this);
        System.out.println("Select a contact number: ");
        Contact c = entries[sc.nextInt()];
        sc.nextLine();
        System.out.println("Enter a new name: ");
        c.setName(sc.nextLine());
        System.out.println("Enter a new address: ");
        c.setAddress(sc.nextLine());
        System.out.println("Enter a new phone number: ");
        c.setPhone(sc.nextLine());
        System.out.println("Enter a new email address: ");
        c.setEmail(sc.nextLine());
    }

    /**
     * This method removes item from the Contacts array.
     * @param sc takes scanner object as parameter to let the user pick an item to remove.
     */
    public void remove(Scanner sc) {
        System.out.println(this);
        System.out.println("Select a contact number: ");
        int i = sc.nextInt();
        sc.nextLine();
        if (i >= 0 && i < entries.length) {
            for (; i < entries.length - 1; i++) {
                entries[i] = entries[i + 1];
            }
            entries = Arrays.copyOf(entries, entries.length - 1);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < entries.length; i++) {
            result += i + "\t" + entries[i].toString() + "\n";
        }
        return result;
    }

    /**
     *This will prompt the user for a filename and save the entries using fileMan
     * @param sc - uses scanner object as parameter to get the name of the file to save.
     */
    public void save(Scanner sc) {
        System.out.println("Please enter a file name:");
        try {
            fileMan.writeContacts(scn.nextLine(), entries);
        } catch (IOException ex) {
            System.out.println("Unable to save file");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This will prompt the user for a filename and load the entries using fileMan
     * @param sc - take scanner object as parameter to the name of the file to load
     */
    public void load(Scanner sc) {
        System.out.println("Enter a file name to load:");
        try {
            fileMan.readContacts(scn.nextLine());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Unable to load file");
            System.out.println(ex.getMessage());
        }

    }

}
