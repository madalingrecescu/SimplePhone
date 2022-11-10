import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactList;

    public MobilePhone() {
        this.contactList = new ArrayList<Contacts>();
    }

    public void printContacts() {
        System.out.println("you have " + contactList.size() + "  items in your contact list");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i + 1 + ". " + contactList.get(i).getName() + "  " + contactList.get(i).getPhoneNumber());
        }
    }
    private boolean alreadyExists(String name){
        int doesAlreadyExist = findContact(name);
        return doesAlreadyExist >= 0;
    }
    public void addContact(String name, String phoneNumber) {

        if(alreadyExists(name)){
            System.out.println("the contact name alreay exists.");
        } else {
            Contacts contact = new Contacts(name, phoneNumber);
            contactList.add(contact);
        }
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            removeContact(position);
        }
    }

    public int searchContact(String searchName) {
        return findContact(searchName);
    }

    public void updateContact(String name, String newName, String newNumber) {
        if(alreadyExists(newName)){
            System.out.println("the contact name alreay exists.");
        } else {
            int position = findContact(name);
                updateContact(position, newName, newNumber);
        }
    }


    private void removeContact(int position) {
        this.contactList.remove(position);
    }

    private int findContact(String searchName) {
        for (int i = 0; i < this.contactList.size(); i++) {
            if (searchName.equals(this.contactList.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    private void updateContact(int position, String newName, String newNumber) {
        Contacts newContact = new Contacts(newName, newNumber);
        contactList.set(position, newContact);
        System.out.println("Contact number " + (position + 1) + " has been updated.");
    }
}
