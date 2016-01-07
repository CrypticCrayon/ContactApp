/*
 Shanaz Mohamed
 IOAppContactBook- This project creates a contact book and save them to a files in the system 
 and loads the files from the system by printing back the content of the file.
 */

package mohames4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 *This class has two methods to write contact objects to file and read 
 * contact objects from a file by using input and output streams.
 */
public class ContactFileManager {

    /**
     * writeContacts method writes the Contact object's data to a given file name. 
     * @param fileName - takes the name of the file (fileName) parameter to write the contacts to given file name
     * @param contact - takes an array of Contact objects the user inputs when creating Contact object.
     * @throws IOException
     */
        public void writeContacts(String fileName, Contact[] contact) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Contact c : contact) {
                oos.writeObject(c);

            }
        }
    }

    /**
     * readContacts method reads the Contact object's data from a given file name.
     * @param fileName - takes a string fileName which is the filename to read from.
     * @return contacts - returns Contact object 
     * @throws IOException  
     * @throws ClassNotFoundException 
     */
    public Contact[] readContacts(String fileName) throws IOException, ClassNotFoundException {

        Contact[] contacts = new Contact[1];
        
        int counter = 0;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            while (true) {

                contacts[counter] = (Contact) ois.readObject();
                contacts[counter].display();
                  counter++;

                if (counter >= contacts.length) {
                    contacts = Arrays.copyOf(contacts, counter + 1);
                }
              
                
            }

        } catch (EOFException e) {
        }
        
        return contacts;
    }
}
