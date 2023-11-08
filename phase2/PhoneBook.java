package phase2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class PhoneBook {
    private ContactBST contactTree;
    private List<Event> events;

    public PhoneBook() {
        contactTree = new ContactBST();
        events = new ArrayList<>();
    }

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
                
                break;
            case 2:
                // Search for a contact
                System.out.println("Enter search criteria:");
                // Prompt the user to select search criteria
                String criteria = scanner.nextLine();
                System.out.print("Enter the search term: ");
                String searchTerm = scanner.nextLine();
                phonebook.searchContact(criteria, searchTerm);
                break;
            case 3:
                // Delete a contact
                System.out.print("Enter the contact's name: ");
                String deleteName = scanner.nextLine();
                phonebook.deleteContact(deleteName);
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
                String firstName = scanner.nextLine();
                // Implement this part based on the project description
                break;
            case 7:
                // Print all events alphabetically
                phonebook.listAllEventsAlphabetically();
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
