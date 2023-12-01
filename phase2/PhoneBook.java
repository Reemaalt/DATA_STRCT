package phase2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhoneBook {

    private ContactBST <Contact> contactTree=new ContactBST<Contact>();
    private linkedlist<Events> ALLevents = new linkedlist<Events>();

    // Print all events :Method to print all events by title or contact name.
    public void printEventsByTitleOrContact(String searchTerm) {
      linkedlist<Events> searchResults = new linkedlist<Events>();
        nodeLL<Events> tem = ALLevents.getHead();

        while (tem != null) {
            if (tem.getData().getTitle().equalsIgnoreCase(searchTerm) ||
                    tem.getData().getContactname().equalsIgnoreCase(searchTerm) ||
                    containsIgnoreCase(tem.getData().getInvoledContacts(), searchTerm)) {

                searchResults.Add(tem.getData());
            }
            tem = tem.getNext();
        }

        if (searchResults.isEmpty()) {
            System.out.println("No event found.");
        } else {
            System.out.println("Events Found! \n");
            nodeLL<Events> tmp = searchResults.getHead();
            while (tmp != null) {
                System.out.println(tmp.getData().toString());
                tmp = tmp.getNext();
            }
        }
    }

    // i added this method so the above print works
    private boolean containsIgnoreCase(linkedlist<String> list, String searchTerm) {
 nodeLL<String> tmp = list.getHead();
       while (tmp != null)  {
           // String item = tmp.getData();
            if ( tmp.getData().equalsIgnoreCase(searchTerm)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    /*
     * Write a method that will list all events and appointments available ordered
     * alphabetically by
     * event/appointment name in O(n) time
     * ALLevents is already sorted, and we are  just iterating through it,
     *  the time complexity would be O(n).
     */
    public void listAllEventsAlphabetically() {
        if (ALLevents.isEmpty()) {
            System.out.println("No events or appointments found.");
            return;
        }

        linkedlist<Events> sortedEvents = ALLevents; // ALLevents is already sorted right?

        System.out.println("All events and appointments ordered alphabetically:");
        nodeLL<Events> tmp = sortedEvents.getHead();
        while (tmp != null) {
            System.out.println(tmp.getData().toString());
            tmp = tmp.getNext();
        }
    }

    // method to call add contact from the BST class
    public void AddContact(Contact c, String name) {
        if (contactTree.addcontact(c, name))
            System.out.println("Contact added successfully! ");
        else
            System.out.println("Couldn't add contact :( ");
    }

    // // no conflict in event/appointment scheduling. A new event
    // should/appointment not
    // be scheduled for a contact if it has a conflict with a current scheduled
    // event/appointment that the
    // phonebook user has.
    public boolean eventConflict(Contact contact, Events newEvent) {
        nodeLL<Events> tmp = (contact.getEvents().getHead());

        while (tmp != null) {
            if (tmp.getData().getDateTime().equals(newEvent.getDateTime())) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    // cheak befor adding a new event to BST and ALLevents
    // calls add event only if contact exist in bst
    public boolean addeventOrapp(Events event, Contact contact) {

        if (contactTree.contactExists(contact)) {

            contact.addEvent(event);
            ALLevents.Add(event);
            return true;
        } else
            return false;
    }

    // the menu
    public void runPhoneBook (){
        
    Scanner scanner=new Scanner (System.in);
    System.out.println("Welcome to the Phonebook!");
    int choice;
    do {
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
       
        
        choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        switch (choice) {
        // Add a contact
            case 1:
                
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
                System.out.println("Enter search criteria:\n 1. Name\n2. Phone Number\n3. Email Address\n4. Address\n5. Birthday\n");

                int number = scanner.nextInt();
                scanner.nextLine(); 

                switch(number) {

                    case 1:
                        System.out.println("Enter the contact's name:");
                        String Contname = scanner.nextLine();
                        Contact n=contactTree.searchKey(Contname);
                        System.out.println(n.toString());
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
            or appointment that the contact in the event exist in the contact BST. All contacts need to be in the*/
            case 3:
                    // Delete a contact
                    System.out.print("Enter the contact's name: ");
                    String deleteName = scanner.nextLine();
                    contactTree.deleteContact(deleteName);
                    ALLevents.setCurrent(ALLevents.getHead());
                 
                    while (ALLevents.getCurrent() != null) {
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

             //Schedule an event/appointment                
            case 4:
                System.out.println("Enter type:\n 1.event\n2.appointment\n Enter choice: ");
                int chice=scanner.nextInt();
                                scanner.nextLine(); 

                switch (chice){
                        case 1: 
                        System.out.println("Enter event title:");
                        String title= scanner.nextLine();
                        System.out.println("Enter contact name:");
                        String Cname= scanner.nextLine();
                        System.out.println("Enter event date and time (yyyy-MM-dd HH:mm:ss): ");
                        String useredate = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime edate = LocalDateTime.parse(useredate, formatter);
                        System.out.println("Enter event location:");
                        String eloc= scanner.nextLine();
                        if(contactTree.findkey(Cname)){
                        Contact Cfound = contactTree.searchKey(Cname);
                        Events e1=new Events(title,edate,eloc,false,Cname);
                        addeventOrapp(e1, Cfound);
                        
                    }
                    break;

                    case 2:
                    System.out.println("Enter appointment title:");
                    String titleA = scanner.nextLine();
                    System.out.println("Enter contact name:");
                    String CnameA = scanner.nextLine();
                    System.out.println("Enter event date and time (yyyy-MM-dd HH:mm:ss): ");
                    String useredateA = scanner.nextLine();
                    DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime edateA = LocalDateTime.parse(useredateA, formatterA);
                    System.out.println("Enter appointment location:");
                    String elocA = scanner.nextLine();
                    
                    if (contactTree.findkey(CnameA)) {
                        Contact CfoundA = contactTree.searchKey(CnameA);
                        Events app1 = new Events(titleA, edateA, elocA, true, CnameA);
                        
                        // Add the appointment to the phone book
                        addeventOrapp(app1, CfoundA);
                    } else {
                        System.out.println("Contact not found. Please add the contact first.");
                    }
                    break;
                
                    }
            break;

            // Print event details
            case 5:
                    
            System.out.println("Enter search criteria:");
            System.out.println("1. Contact name");
            System.out.println("2. Event title");
            System.out.print("Enter your choice: ");
            int searchChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (searchChoice) {
                case 1:
                    System.out.println("Enter the contact's name:");
                    String contactName = scanner.nextLine();
                    
                    // Check if the contact exists before searching for events
                    if (contactTree.findkey(contactName)) {
                        printEventsByTitleOrContact(contactName);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the event title:");
                    String eventTitle = scanner.nextLine();
                    printEventsByTitleOrContact(eventTitle);
                    break;

                default:
                    System.out.println("Invalid input!!");
                    break;
            }
            break;

                        
                        
            
            // Print contacts by first name
            case 6:
            System.out.print("Enter the first name: ");
            String firstName = scanner.nextLine();
        
            if (contactTree.isEmpty())
                System.out.println("No Contacts found!");
            else
                contactTree.searchSameFirstName(firstName);
            break;
        
        
            
            // Print all events alphabetically
            case 7:
                // just this ?? idk 
            listAllEventsAlphabetically();

            break;
            case 8:
                System.out.println("Goodbye!");
                System.exit(0);

            break;
            
                default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
    while(choice!=8);
    scanner.close();
}

    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        phonebook.runPhoneBook();
    }// main
}
