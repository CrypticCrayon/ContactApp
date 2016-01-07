/*
 Shanaz Mohamed
 IOAppContactBook- This project creates a contact book and save them to a files in the system 
 and loads the files from the system by printing back the content of the file.
 */
package mohames4;

import java.io.Serializable;

/**
 *
 * This class helps get and set name address phone and email from the user. It
 * implements serializable interface.
 */
public class Contact implements Serializable {

    private String name;
    private String address;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\t" + address + "\t" + phone + "\t" + email;
    }

    /**
     *This method is used to display the contents of the contact object in a customized way.
     */
    public void display() {
        System.out.print(name + "\t");
        System.out.print(address + "\t");
        System.out.print(phone + "\t");
        System.out.print(email + "\t");
        System.out.println();
    }

}
