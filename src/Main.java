//Create a p


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                default:
                    quit = true;
                    break;

            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print your options");
        System.out.println("\t 1 - To print the list of contacts");
        System.out.println("\t 2 -  To add a contact");
        System.out.println("\t 3 -  To modify a contact");
        System.out.println("\t 4 -  To remove a contact");
        System.out.println("\t 5 -  To search for a contact");
        System.out.println("\t 6 -  To quit the application");
    }

    public static void addContact(){
        System.out.println("Please enter the name of the contact");
        String name = scanner.nextLine();
        System.out.println("Please enter the number of the contact");
        String phoneNumber = scanner.nextLine();
        mobilePhone.addContact(name,phoneNumber);
    }

    public static void updateContact(){
        System.out.println("Please enter the name of the contact that you want to update: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the new name of the contact: ");
        String newName = scanner.nextLine();
        System.out.println("Please enter the new number of the contact: ");
        String phoneNumber = scanner.nextLine();
        mobilePhone.updateContact(name,newName,phoneNumber);
    }

    public static void removeContact(){
        System.out.println("Please enter the name of the contact that you want to remove: ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    public static void  searchForContact(){
        System.out.println("Please enter the name of the contact that you want to search: ");
        int ok = mobilePhone.searchContact(scanner.nextLine());
        if(ok >= 1){
            System.out.println("The contact has been found in the " + ok + " position");
        } else{
            System.out.println("The contact has not been found");
        }
    }
}