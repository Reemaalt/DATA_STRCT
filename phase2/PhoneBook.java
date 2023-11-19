package phase2;

import java.util.Scanner;

import org.w3c.dom.events.Event;
public class PhoneBook {

private ContactBST contactTree;
private linkedlist<Event> ALLevents = new linkedlist<>();


 // Method to print all events by title or contact name.
 public void printEventsByTitleOrContact(String criteria, String searchTerm) {
        for (Event event : events) {
            if (criteria.equals("contact name") && event.isContactInEvent(searchTerm)) {
                System.out.println(event.toString());
            } else if (criteria.equals("Event title") && event.getTitle().equalsIgnoreCase(searchTerm)) {
                System.out.println(event.toString());
            }
        }
 }

public void AddContact(Contact c, String name){
        if (contactTree.addcontact(c, name))
        System.out.println("Contact added successfully! ");
        else 
        System.out.println("Couldn't add contact :( ");
}
    
public boolean addeventapp (Event event , Contact c){
        //calls add event only if contact exist in bst
 }


    public void runPhoneBook (){
    Scanner scanner=new Scanner (System.in);
    System.out.println("Welcome to the Phonebook!");

    while (true) {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event/appointment");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");

        System.out.print("Enter your choice: ");
       
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (choice) {
            case 1:
                // Add a contact
                System.out.print("Enter the contact's name: ");
                String name = scanner.nextLine();
                System.out.println("Enter the contact's phone number:");
                String phone= scanner.nextLine();
                System.out.println("Enter the contact's email address: ");
                String email= scanner.nextLine();
                System.out.println("Enter the contact's address:");
                String address= scanner.nextLine();
                System.out.println("Enter the contact's birthday:");
                String bday= scanner.nextLine(); 

               System.out.println("Enter any notes for the contact:");
                String note= scanner.nextLine();

                Contact c1=new Contact( name, phone, email, address, bday, note);
                AddContact(c1, name);

                
                break;

                // Search a contact
            case 2:
                System.out.println("Enter search criteria:/n 1. Name/n2. Phone Number/n3. Email Address/n4. Address/n5. Birthday/n");

                int number = scanner.nextInt();
                scanner.nextLine(); 

                switch(number) {

                    case 1:
                        System.out.println("Enter the contact's name:");
                        String Contname = scanner.nextLine();
                        contactTree.searchKey(Contname);
                        break;

                    case 2:
                        System.out.println("Enter the contact's phone number:");
                        String Contphone = scanner.nextLine();
                        contactTree.searchByCriteria(1, Contphone);
                        break;

                    case 3:
                        System.out.println("Enter the contact's email address:");
                        String Contemail = scanner.nextLine();
                        contactTree.searchByCriteria(2, Contemail);
                        break;

                    case 4:
                        System.out.println("Enter the contact's address:");
                        String Contadd = scanner.nextLine();
                        contactTree.searchByCriteria(3, Contadd);
                        break;

                    case 5:
                        System.out.println("Enter the contact's birthday:");
                        String Sbday = scanner.nextLine();
                        contactTree.searchByCriteria(4, Sbday);
                        break;

                    default:
                        System.out.println("Invalid input!!");
                        break;
                }
            break;

            case 3:
                // Delete a contact
                System.out.print("Enter the contact's name: ");
                String deleteName = scanner.nextLine();
                .deleteContact(deleteName);
                break;
            case 4:
                // Schedule an event/appointment
                // Implement this part based on the project description
                break;
            case 5:
                // Print event details
                // Implement this part based on the project description
                break;
            case 6:
                // Print contacts by first name
                System.out.print("Enter the first name: ");
                scanner.nextLine();
                String firstName = scanner.nextLine();

                if (.isEmpty())
                  System.out.println("No Contacts found !");
                else
                  .searchSameFirstName(firstName);
             
                break;
            case 7:
                // Print all events alphabetically
                .listAllEventsAlphabetically();
                break;
            case 8:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}

public static void main(String[] args) {
    PhoneBook phonebook = new PhoneBook();
    phonebook.runPhoneBook();
}//main
}
