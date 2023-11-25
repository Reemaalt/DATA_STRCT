package phase2;

import java.util.LinkedList;
import java.util.Scanner;

import org.w3c.dom.events.Event;


public class PhoneBook {

private ContactBST contactTree;
private linkedlist<Events> ALLevents = new linkedlist<Events>();

/*• There should be no conflict in event/appointment scheduling. A new event should/appointment not
be scheduled for a contact if it has a conflict with a current scheduled event/appointment that the
phonebook user has. */


//Print all events :Method to print all events by title or contact name.
 public void printEventsByTitleOrContact(String searchTerm) {
         linkedlist<Events> searchResults = new linkedlist<Events>();
         nodeLL<Events>  tem = ALLevents.getHead();
        
        while (tem!=null) {
            if (tem.getData().getTitle().equalsIgnoreCase(searchTerm) ||
                    tem.getData().getContactname().equalsIgnoreCase(searchTerm) ||
                    tem.getData().getInvoledContacts().equalsIgnoreCase(searchTerm))//IDK if this would work 
                     {
                searchResults.Add(tem.getData());
            }
            tem = tem.getNext();
        }
        if (searchResults.isEmpty()) {
            System.out.println("No event found.");
        } else {
            System.out.println("events Found! /n");
            nodeLL<Events> tmp = searchResults.getHead();
            while (tmp != null) {
                System.out.println(tmp.getData().toString());
                tmp = tmp.getNext();
            }
            }
        }
 

 /*Write a method that will list all events and appointments available ordered alphabetically by
event/appointment name in O(n) time */

public void AddContact(Contact c, String name){
        if (contactTree.addcontact(c, name))
        System.out.println("Contact added successfully! ");
        else 
        System.out.println("Couldn't add contact :( ");
}
    
//cheak befor adding a new event to BST and ALLevents
//calls add event only if contact exist in bst
public boolean addeventOrapp(Events event, Contact contact) {

    if (contactTree.contactExists(contact)) {

        contact.addEvent(event);
        ALLevents.Add(event);
        return true;
    } 
    else 
        return false;
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
/*When a contact is deleted, all appointments with that contact are also deleted. If the contact belonged
in a scheduled event, then he should be removed from the event. Make sure before adding an event
or appointment that the contact in the event exist in the contact BST. All contacts need to be in the
contact BST before an event is added. */
//delet bst --> delete contact involedContacts -->???
//delet app from all
            case 3:
                // Delete a contact
                System.out.print("Enter the contact's name: ");
                String deleteName = scanner.nextLine();
                contactTree.deleteContact(deleteName);
                ALLevents.setCurrent(ALLevents.getHead());
                 
                for (int i = 0; i < ALLevents.size(); i++) {
            if (!ALLevents.getCurrent().getData().isAppointment()) {
                // The event is not an appointment, check if the contact is in the list
                if (ALLevents.getCurrent().getData().hasContact(deleteName))
                {
                    System.out.println("contact deleated from event ");
                } 
                else {
                    System.out.println("contact wasnt in any events");
                }
            }
             ALLevents.setCurrent(ALLevents.getCurrent().getNext());
        }

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

                if (contactTree.isEmpty())
                  System.out.println("No Contacts found !");
                else
                  contactTree.searchSameFirstName(firstName);
             
                break;
            case 7:
                // Print all events alphabetically
                //contactTree.listAllEventsAlphabetically();
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
