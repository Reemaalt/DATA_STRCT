//import java.time.LocalDateTime;
import java.util.Objects;
// Event class that represents events or appointments with contacts

public class Event {


    // Fields for the event title, date and time, location, and contact
    private String title;
    //private LocalDateTime dateTime;
    private String location;
    private Contac contact;

    // Constructor 
    public Event(String title, LocalDateTime dateTime, String location, Contac contact) {
        this.title = title;
       // this.dateTime = dateTime;
        this.location = location;
        this.contact = contact;
    }

    // Getter and setter methods for the fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contac getContact() {
        return contact;
    }

    public void setContact(Contac contact) {
        this.contact = contact;
    }

    // Method that compares events by their titles alphabetically

    public int compareTo(Event other) {
        return this.title.compareTo(other.title);
    }

    // Method that checks if two events are equal based on their titles and contacts
    
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event other = (Event) obj;
            return this.title.equals(other.title) && this.contact.equals(other.contact);
        }
        return false;
    }

        
        private Node head;

        
          
        
    
        // A method that adds an event to the list شرط ان الكونتكت يكون موجود بالكونكت لست و ان مايكون في تعارض 
        public void addEvent(Event event) {
            Node new Node = new Node(event);
            new Node.setNext(head);
            head = newNode; }
    
 // A method that searches for an event based on the event title or contact name تغير لان تستقبل ايفينت 
 public Event searchEvent(Node eventNode ) {
    Node current = head;
    while (current != null) {
        Event event = current.getEvent();
        // Check if the event has a matching title and contact name
        if (event.getTitle().equals(title) || event.getContact().getname().equals(name)) {            
        return event;
        }
        current = current.getNext();
    }
    return null;
}

// A method that deletes all events with a given contact
public void deleteEvents(Contac contact) {
    Node prev = null;
    Node current = head;
    // Loop until the end of the list or all matches are removed
    while (current != null) {
        
        Event event = current.getevent();
        
        if (event.getContact().equals(contact)) { 
            if (prev == null) {
                head = current.getNext();
            } else {
                prev.setNext(current.getNext());
            }
        } else {
            prev = current;
        }
        current = current.getNext();
    }
}


}

