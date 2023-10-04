import java.util.*;
public class PhoneBook {
    private LinkedList <Contact> contacts;

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public void deleteContact(Contact contact) {
        if (contacts.remove(contact)) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    
/* 
    public void printContactsSharingFirstName(String firstName) {
        List<Contact> contactsSharingFirstName = new LinkedList<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(firstName)) {
                contactsSharingFirstName.add(contact);
            }
        }
        if (contactsSharingFirstName.isEmpty()) {
            System.out.println("No contacts found sharing this first name.");
        } else {
            System.out.println("Contacts sharing the first name:");
            for (Contact contact : contactsSharingFirstName) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmail());
            }
        }
    }
*/
//reema
    public List<Contact> searchContactByCriteria(String criteria) {
        List<Contact> searchResults = new LinkedList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(criteria) ||
                    contact.getPhoneNumber().equalsIgnoreCase(criteria) ||
                    contact.getEmail().equalsIgnoreCase(criteria) ||
                    contact.getAddress().equalsIgnoreCase(criteria) ||
                    contact.getBirthday().equalsIgnoreCase(criteria)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmail());
            }
        }
    }

    public void scheduleEvent(Event event) {
        Contact contact = event.getContact();
        if (contacts.contains(contact)) {
            // Check for event conflicts
            if (!hasEventConflict(contact, event)) {
                contact.addEvent(event);
                System.out.println("Event scheduled successfully.");
            } else {
                System.out.println("There is a conflict with an existing event for this contact.");
            }
        } else {
            System.out.println("Contact does not exist.");
        }
    }
//yara
    public void printContactsSharingEvent(Event event) {
        List<Contact> contactsSharingEvent = new LinkedList<>();
        for (Contact contact : contacts) {
            if (contact.hasEvent(event)) {
                contactsSharingEvent.add(contact);
            }
        }
        if (contactsSharingEvent.isEmpty()) {
            System.out.println("No contacts found sharing this event.");
        } else {
            System.out.println("Contacts sharing the event:");
            for (Contact contact : contactsSharingEvent) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmail());
            }
        }
    }

    public void printAllEventsAlphabetically() {
        LinkedList<Event> allEvents = new LinkedList<>();
        for (Contact contact : contacts) {
            allEvents.addAll(contact.getEvents());
        }
        allEvents.sort((e1, e2) -> e1.getTitle().compareToIgnoreCase(e2.getTitle()));

        if (allEvents.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("All events ordered alphabetically:");
            for (Event event : allEvents) {
                System.out.println(event.getTitle() + " - " + event.getDateTime() + " - " + event.getLocation());
            }
        }
    }

    private boolean hasEventConflict(Contact contact, Event newEvent) {
        for (Event event : contact.getEvents()) {
            if (event.getDateTime().equalsIgnoreCase(newEvent.getDateTime())) {
                return true;
            }
        }
    }


   
    public static void main(String[] args) {
       Scanner input=new Scanner (System.in);
       contacts = new LinkedList<>();
       
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
                
                Contact c1= new Contact(name,phone,email,address,bday,note);
                contactlist.Add(c1);
                
                break;
            case 2:
                System.out.println("Enter search criteria:\n1.Name\n2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday\n");
                int criteria;
                switch(criteria){
                    case 1:
                        System.out.println("Enter the contact's name:"); 
                        String Sname=input.next();
                        contactlist.Search(Sname);
                        break;
                    case 2:
                        System.out.println("Enter the contact's phone number:");
                        String Sphone=input.next();
                        contactlist.Search(Sphone);
                        break;
                    case 3:
                        System.out.println("Enter the contact's email address:");
                        String Semail=input.next();
                        contactlist.Search(Semail);
                        break;
                    case 4:
                        System.out.println("Enter the contact's address:");
                        String Saddress=input.next();
                        contactlist.Search(Saddress);
                        break;
                    case 5:
                        System.out.println("Enter the contact's birthday:");
                        String Sbday=input.next();
                        contactlist.Search(Sbday);
                        break;
                }
                
                break;
            case 3:
                contactlist.Delete();
                break;
            case 4:
                System.out.println("Enter event title:");
                String title= input.nextLine();
                System.out.println("Enter contact name:");
                String Cname= input.nextLine();
                System.out.println("Enter event date and time (MM/DD/YYYY HH:MM): ");
                String edate = input.nextLine();
                System.out.println("Enter event location:");
                String eloc= input.nextLine();
                
                Event e1=new Event(title,edate,eloc,Cname);
                eventlist.addEvent(e1);
                break;
            case 5:
             System.out.println("Enter search criteria:\n 1.contactname \n 2.Event tittle");
                   int scriteria =input.nextLine();
                   switch(scriteria){
                    case1:
                    System.out.println("Enter contact's name");
                     String cname=input.nextLine()
                     eventlist.Searchevent(cname);
                     break;
                     case 2:
                     System.out.println("Enter event title");
                     String etitle =input.nextLine();
                     eventlist.Searchevent(etitle);
                     break;
                   }
            break;

            case 6:
            System.out.println("Enter the first name:");
            String fname= input.nextLine();
            contactlist.Search(fname);
            break;

            case 7:
            eventlist.print();//do we have this method?
            break;

            case 8:
            System.out.println("Goodbye!");
            break;

            break;//should we?
                
                
                

        }
        
    }
    
}
