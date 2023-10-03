import java.util.*;
public class PhoneBook {

   
    public static void main(String[] args) {
       Scanner input=new Scanner (System.in);
       LinkedList contactlist = new LinkedList();
       LinkedList eventlist= new LinkedList();

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
