/*-Phonebook: This class will represent the phonebook application itself. It should have a field for
the linked list ADT that stores the contacts and methods for interacting with the list (e.g., adding,
searching, and deleting contacts). You will also need to schedule events and appointments with
contacts. */

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
public class PhoneBook  {

public static LinkedList<Contact> contacts = new LinkedList<>();


/*Each contact in the phonebook should be unique. You can ensure this by checking if a contact with
the same name or phone number already exists in the list before adding a new contact.*/
    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.AddContact(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Contact already exists.");
        }
    }

//When a contact is deleted all events with that contact are also deleted.
    public void deleteContact(Contact contact) {
        
        if (contacts.DeleteContact(contact)) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
 
/*The Phonebook class should have methods for printing all contacts that share an event as well as all
contacts that share the first name.*/
    public  void printContactsSharingFirstName(String firstName) {
         LinkedList<Contact> contactsSharingFN = new LinkedList<>();
         Node<Contact> tem= contacts.getHead() ;
         while (contacts.hasNext()) {
            if (contacts.startsWith(((Contact) tem.getData()).getname(), firstName)) {
                contactsSharingFN.AddContact(tem.getData());
            }
            tem = tem.getNext();
        } //end of while 

        if (contactsSharingFN.isEmpty()) {
            System.out.println("No contacts found sharing this first name.");
        } else {
            System.out.println("Contacts Found! /n");
             Node<Contact> tmp= contacts.getHead() ;
             while (contactsSharingFN.hasNext()) { {
                System.out.println(((Contact) tmp.getData()).toString() );
                tmp=tmp.getNext();
            }
             }}       
    }
  
 /*When you search for a contact by email address, address, or birthday, you should return all contacts
that have these values*/
    public  void searchContactByCriteria(String criteria) {
        LinkedList<Contact> searchResults = new LinkedList<>();
       Node<Contact> tem= contacts.getHead() ;
         while (contacts.hasNext())  {
            if (tem.getData().getname().equalsIgnoreCase(criteria) ||
                    tem.getData().getPhoneNumber().equalsIgnoreCase(criteria) ||
                    tem.getData().getEmailAddr().equalsIgnoreCase(criteria) ||
                    tem.getData().getAddress().equalsIgnoreCase(criteria) ||
                    tem.getData().getBirthday().equalsIgnoreCase(criteria)) {
                searchResults.AddContact(tem.getData());
            } tem = tem.getNext();
        }
       if (searchResults.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts Found! /n");
             Node<Contact> tmp= searchResults.getHead() ;
             while (searchResults.hasNext()) { {
                System.out.println(((Contact) tmp.getData()).toString() );
                tmp=tmp.getNext();
            }
             }}
    }

/*The Phonebook class should have methods for printing all contacts that share an event as well as all
contacts that share the first name.*/
    public void printContactsSharingEvent(Event event) {
        LinkedList <Contact> SharingEvent = new LinkedList<>();
        Node<Contact> tem= contacts.getHead() ;
         while (contacts.hasNext()) {
            if (contacts.hasTheEvent(event)) {
               SharingEvent.AddContact(tem.getData());
            }
            tem=tem.getNext();
        }
        if (SharingEvent.isEmpty()) {
            System.out.println("No contacts found sharing this event.");
        } else {
            System.out.println("Contacts sharing the event:");
             Node<Contact> tmp= contacts.getHead() ;
             while (SharingEvent.hasNext()) {  {
                System.out.println(((Contact) tmp.getData()).toString());
                tmp=tmp.getNext();
            }
     
                }   }
    }

//Write a method that will list all events available ordered alphabetically by event name in O(n) time
// A method to print all events in alphabetical order
    public void printAllEventsAlphabetically(Contact c1) {
    // Use a temporary node to store the head of the list
    Node<Event> temp =  c1.getEvents().getHead() ;
    // Loop until the list is empty
    while (temp != null) {
      // Find the node with the smallest event name in the list
      Node<Event> min = temp;
      Node<Event> current = temp.next;
      while (current != null) {
        if (current.getData().getTitle().compareTo(min.getData().getTitle()) < 0) {
          min = current;
        }
        System.out.println(min.getData().getTitle());
        current = current.next;

      }
    
    }
  }
  
/*There should be no conflict in event scheduling. A new event should not be scheduled for a contact if
it has a conflict with a current scheduled event.*/
//erorr3 LIKE SCREENSHOT AND ASK ABT TIME CONFLICT STRING
    private boolean EventConflict(Contact contact, Event newEvent)
    {
       
         for (Event event : (contacts.getData).getEvents()){

       /*  Node<Contact> temp = contacts.getHead();
        while (temp != null) {
            Contact contact = temp.getData();
            LinkedList<Event> events = contact.getEvents(); */
        
        for (Event event : contacts.getData.getEvent()) {
            //already scheduled = conflict
            if (event.getDateTime().equals(newEvent.getDateTime())) {
                return true;
            }
        }
        return false;
    }
     
    public void scheduleEvent(Event event , Contact contact ) {
        
            // Check for event conflicts
            if (!EventConflict(contact, event)) {
                contact.getEvents().AddEvent(event);
                System.out.println("Event scheduled successfully.");
            } else {
                System.out.println("There is a conflict with an existing event for this contact.");
            }
        
        }
    
    
    //ماشفت المين ابددد
    public static void main(String[] args) {
       Scanner input=new Scanner (System.in);
       LinkedList <Contact> contacts = new LinkedList<Contact>();
       LinkedList <Event> events = new LinkedList<Event>();
       
        System.out.println("Welcome to the Linked Tree Phonebook!\n");
        System.out.println("Please choose an option:\n 1.Add a contact\n 2. Search for a contact\n 3.Delete a contact\n 4.Scheduleanevent \n 5.Printeventdetails\n 6.Printcontact byfirstname\n 7. Print all events alphabetically\n 8.Exit");
        int choice;
        System.out.println("Enter your choice:");
        choice=input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the contact's name: ");
                String name= input.nextLine();
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
                
<<<<<<< Updated upstream
                Contact c1= new Contact(name,phone,email,address,bday,note);
=======
                Contact c1= new Contact(name,phone,email,address,bday,note,events);
>>>>>>> Stashed changes
                contacts.AddContact(c1);
                
                break;
            case 2:
                System.out.println("Enter search criteria:\n1.Name\n2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday\n");
                int criteria;
                switch(criteria){ //move method to ll
                    case 1:
                        System.out.println("Enter the contact's name:"); 
                        String Sname=input.next();
                        contacts.searchContactByCriteria(Sname);
                        break;
                    case 2:
                        System.out.println("Enter the contact's phone number:");
                        String Sphone=input.next();
                        contacts.searchContactByCriteria(Sphone);
                        break;
                    case 3:
                        System.out.println("Enter the contact's email address:");
                        String Semail=input.next();
                        contacts.searchContactByCriteria(Semail);
                        break;
                    case 4:
                        System.out.println("Enter the contact's address:");
                        String Saddress=input.next();
                        contacts.searchContactByCriteria(Saddress);
                        break;
                    case 5:
                        System.out.println("Enter the contact's birthday:");
                        String Sbday=input.next();
                        contacts.searchContactByCriteria(Sbday);
                        break;
                }
                
                break;
            case 3:
            //how to give the contact we want to delete
                contacts.DeleteContact();
                break;
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
                //how to give it a contact
                Event e1=new Event(title,edate,eloc,Cname);
                //event list wrong
                events.AddEvent(e1);
                break;
            case 5:
             System.out.println("Enter search criteria:\n 1.contactname \n 2.Event tittle");
                   int scriteria =input.nextInt();
                   switch(scriteria){
                    case 1:
                    System.out.println("Enter contact's name");
                     String cname=input.nextLine()
                     //eventlist wrong
                     events.Searchevent(cname);
                     break;
                     
                     case 2:
                     System.out.println("Enter event title");
                     String etitle =input.nextLine();
                     events.Searchevent(etitle);
                     break;
                   }
            break;

            case 6:
            System.out.println("Enter the first name:");
            String fname= input.nextLine();
            contacts.searchContactByCriteria(fname);
            break;

            case 7:

            printAllEventsAlphabetically();//not sure
            break;

            case 8:
            System.out.println("Goodbye!");
            break;

            break;//should we?
                
                
                

        }
        
    }
    
    }}