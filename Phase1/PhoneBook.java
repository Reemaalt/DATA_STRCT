/*-Phonebook: This class will represent the phonebook application itself. It should have a field for
the linked list ADT that stores the contacts and methods for interacting with the list (e.g., adding,
searching, and deleting contacts). You will also need to schedule events and appointments with
contacts. */

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;

//case5 & bigOs & test all case & exsp 

public class PhoneBook {
    private LinkedList<Contact> contacts;

    public PhoneBook() {
        contacts = new LinkedList<Contact>();
    }


    /*
     * Each contact in the phonebook should be unique. You can ensure this by
     * checking if a contact with
     * the same name or phone number already exists in the list before adding a new
     * contact.
     */
    

    // When a contact is deleted all events with that contact are also deleted.
    public void deleteContact(String contactName) {
        Contact contactToRemove = searchContact(contactName);
        if (contactToRemove != null) {
            contacts.DeleteContact(contactToRemove);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    /*
     * The Phonebook class should have methods for printing all contacts that share
     * an event as well as all
     * contacts that share the first name.
     */
    public  void printContactsSharingFirstName(String firstName) {
        LinkedList<Contact> contactsSharingFN = new LinkedList<>();
        Node<Contact> tem = contacts.getHead();
        while (tem!=null) {
            if (contacts.startsWith(((Contact) tem.getData()).getname(), firstName)) {
                contactsSharingFN.AddContact(tem.getData());
            }
            tem = tem.getNext();
        } // end of while

        if (contactsSharingFN.isEmpty()) {
            System.out.println("No contacts found sharing this first name.");
        } else {
            System.out.println("Contacts Found! /n");
            Node<Contact> tmp = contacts.getHead();
            while (tmp != null) {
                {
                    System.out.println(((Contact) tmp.getData()).toString());
                    tmp = tmp.getNext();
                }
            }
        }
    }

    /*
     * When you search for a contact by email address, address, or birthday, you
     * should return all contacts
     * that have these values
     */
    public  void searchContactByCriteria(String criteria) {
        LinkedList<Contact> searchResults = new LinkedList<>();
        Node<Contact> tem = contacts.getHead();
        while (tem!=null) {
            if (tem.getData().getname().equalsIgnoreCase(criteria) ||
                    tem.getData().getPhoneNumber().equalsIgnoreCase(criteria) ||
                    tem.getData().getEmailAddr().equalsIgnoreCase(criteria) ||
                    tem.getData().getAddress().equalsIgnoreCase(criteria) ||
                    tem.getData().getBirthday().equalsIgnoreCase(criteria)) {
                searchResults.AddContact(tem.getData());
            }
            tem = tem.getNext();
        }
        if (searchResults.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts Found! /n");
            Node<Contact> tmp = searchResults.getHead();
            while (tmp != null) {
                System.out.println(tmp.getData().toString());
                tmp = tmp.getNext();
            }
            }
        }
    

    /*
     * The Phonebook class should have methods for printing all contacts that share
     * an event as well as all
     * contacts that share the first name.
     */
    public void printContactsSharingEvent(Event event) {
        LinkedList<Contact> sharingEvent = new LinkedList<>();
        Node<Contact> tem = contacts.getHead();
        while (tem != null) {
            if (tem.getData().getEvents().hasTheEvent(event)) {
                sharingEvent.AddContact(tem.getData());
            }
            tem = tem.getNext();
        }
        if (sharingEvent.isEmpty()) {
            System.out.println("No contacts found sharing this event.");
        } else {
            System.out.println("Contacts sharing the event:");
            Node<Contact> tmp = sharingEvent.getHead();
            while (tmp != null) {
                System.out.println(tmp.getData().toString());
                tmp = tmp.getNext();
            }
        }
    }
    

    // Write a method that will list all events available ordered alphabetically by
    // event name in O(n) time
    // A method to print all events in alphabetical order
    public  void printAllEventsAlphabetically(Contact c1) {
        // Use a temporary node to store the head of the list
        Node<Event> temp = c1.getEvents().getHead();
        // Loop until the list is empty
        while (temp != null) {
            // Find the node with the smallest event name in the list
            Node<Event> min = temp;
            Node<Event> current = temp.getNext();
            while (current != null) {
                if (current.getData().getTitle().compareTo(min.getData().getTitle()) < 0) {
                    min = current;
                }
                System.out.println(min.getData().getTitle());
                current = current.getNext();

            }

        }
    }

    /*
     * There should be no conflict in event scheduling. A new event should not be
     * scheduled for a contact if
     * it has a conflict with a current scheduled event.
     */
    private  boolean EventConflict(Contact contact, Event newEvent) {
        Node<Event> tmp = (contact.getEvents().getHead());

        while (tmp!=null) {

            if (tmp.getData().getDateTime().equals(newEvent.getDateTime())) {
                return true;
            }
            tmp = tmp.getNext();
        }

        return false;
    }

    public  void scheduleEvent(Event event, Contact contact) {

        // Check for event conflicts
        if (!EventConflict(contact, event)) {
            contact.getEvents().AddEvent(event);
            System.out.println("Event scheduled successfully.");
        } else {
            System.out.println("There is a conflict with an existing event for this contact.");
        }

    }

    public Contact searchContact(String contactName) {
        return searchLinkedList(contacts.getHead(), contactName);
    }

        private Contact searchLinkedList(Node<Contact> node, String contactName) {
            if (node == null) {
                return null;
            }
    
            if (node.getData().getname().equalsIgnoreCase(contactName)) {
                return node.getData();
            }

            
            return searchLinkedList(node.getNext(), contactName);
        }
         

        public LinkedList <Event> searchEventbyTitle(String titleEvent) {
            
            if (contacts.isEmpty() ){
             System.out.println("No Contact in list");
            return null ;
            }
             LinkedList<Event> EventsSharingtitle = new LinkedList<Event>();
             Node <Contact> tmp = new Node <Contact> () ;
            tmp=contacts.getHead();
             while(tmp!= null) {

        Node <Event> tem = new Node <Event> () ;
            tem= tmp.getData().getEvents().getHead();
             while(tem!= null) {
            if (tem.getData().getTitle().compareTo(titleEvent) == 0 ) {
                 EventsSharingtitle.AddEvent(tem.getData());
                
            } 
           tem=tem.getNext();
        }tmp=tmp.getNext(); 
     }   if (EventsSharingtitle.isEmpty()) {
          
            return null ;
        } else {
            System.out.println("Event Found! /n");
           
                return EventsSharingtitle;
            }
            } 

//RUN
public void runPhoneBook (){
    Scanner input=new Scanner (System.in);
        // the contact list 
      
    int choice;
        System.out.println("Welcome to the Linked Tree Phonebook!\n");
      do {  System.gc();
        System.out.println("Please choose an option:\n 1.Add a contact\n 2. Search for a contact\n 3.Delete a contact\n 4.Schedule an event \n 5.Print event details\n 6.Print contact by first name\n 7. Print all events alphabetically\n 8.Exit");
        System.out.println("Enter your choice:");
        choice=input.nextInt();
        input.nextLine();
        switch (choice){
            //Add a contact
        case 1:
                System.out.println("Enter the contact's name: ");
                String namerun= input.nextLine();
                System.out.println("Enter the contact's phone number:");
                String phone= input.nextLine();
                System.out.println("Enter the contact's email address: ");
                String email= input.nextLine();
                System.out.println("Enter the contact's address:");
                String address= input.nextLine();
                System.out.println("Enter the contact's birthday:");
                String bday= input.nextLine(); 

               System.out.println("Enter any notes for the contact:");
                String note= input.nextLine();

                //adding a node of type contact to contacts list
                Contact c1= new Contact(namerun,phone,email,address,bday,note);
                contacts.AddContact(c1);
                break;
            //  Search for a contact
         case 2:
                System.out.println("Enter search criteria:\n1.Name\n2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday\n");
                
                int criteria = input.nextInt();
                switch(criteria){
                    case 1:
                        System.out.println("Enter the contact's name:"); 
                        String Sname=input.nextLine();

                        searchContactByCriteria(Sname);
                        break;
                    case 2:
                        System.out.println("Enter the contact's phone number:");
                        String Sphone=input.nextLine();
                         searchContactByCriteria(Sphone);
                   
                        break;
                        
                    case 3:
                        System.out.println("Enter the contact's email address:");
                        String Semail=input.nextLine();
                        searchContactByCriteria(Semail);
                        break;
                    case 4: 
                        System.out.println("Enter the contact's address:");
                        String Saddress=input.nextLine();
                        searchContactByCriteria(Saddress);
                        break;
                    case 5:
                        System.out.println("Enter the contact's birthday:");
                        String Sbday=input.nextLine();
                        searchContactByCriteria(Sbday);
                        break;
                    default:
                        System.out.println("invailed input!!");
break;
                        }
                        //to exit case 2
                        break; 
                
        //Delete a contact   
        case 3:
            System.out.println("the  FULL name of the contact you want to delete:");
             String fullN=input.nextLine();
              deleteContact(fullN );
                break;
            //Schedule an event
         case 4:
                System.out.println("Enter event title:");
                String title= input.nextLine();
                System.out.println("Enter contact name:");
                String Cname= input.nextLine();
                System.out.println("Enter event date and time (MM/DD/YYYY HH:MM): ");
                String useredate = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime edate = LocalDateTime.parse(useredate, formatter);
                System.out.println("Enter event location:");
                String eloc= input.nextLine();

                Contact Cfound = searchContact(Cname);
                Event e1=new Event(title,edate,eloc,Cfound);
                scheduleEvent(e1, Cfound);
                break;

         //Print event details
        case 5:
                System.out.println("Enter search criteria:\n 1.contactname \n 2.Event tittle");
                   int scriteria =input.nextInt();
                   switch(scriteria){
                    case 1:
                    System.out.println("Enter contact's name");
                     String cname=input.nextLine();
                     printAllEventsAlphabetically(searchContact(cname));
                     break;
                      
                     case 2:
                     System.out.println("Enter event title");
                     String etitle =input.nextLine();
                   LinkedList<Event> FindEvent= searchEventbyTitle (etitle);

                   if (FindEvent == null)
                     System.out.println("No Event");
                     else {
                     Node<Event> temp = FindEvent.getHead();
            while (temp != null) {
                System.out.println(temp.getData().toString());
                temp = temp.getNext();
            }
                     break;
                   }}
            break;
            
        //print ContactsSharing FirstName
        case 6:
            System.out.println("Enter the first name:");
            String fname= input.nextLine();
            printContactsSharingFirstName(fname);
            break;
//print events
        case 7:
    System.out.println("the  FULL name of the contact you want their events:");
             String full=input.nextLine();

            printAllEventsAlphabetically((searchContact(full)));
            break;

        //exiting 
        case 8:
            System.out.println("Goodbye!");
            break;
default:
System.out.println("unrecognized input!!");
                }
                 } while(choice != 8);

                 input.close(); 
                
                

                
    }

    // main method
   public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.runPhoneBook();
    }//main
} //class
