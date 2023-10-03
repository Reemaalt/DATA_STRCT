import java.time.LocalDateTime;
import java.util.Objects;
// Event class that represents events or appointments with contacts

public class Event {


    // Fields for the event title, date and time, location, and contact
    private String title;
    private LocalDateTime dateTime;
    private String location;
    private Contac contact;

    // Constructor 
    public Event(String title, LocalDateTime dateTime, String location, Contac contact) {
        this.title = title;
        this.dateTime = dateTime;
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

        // A field for the head node of the list
        private Node head;

        // A constructor that initializes the head node to null
            head = null;
        }
    
        // A method that adds an event to the list
        public void addEvent(Event event) {
            // Create a new node object for the event
            Node new Node = new Node(event);
            // Link the new node to the head node of the list
            new Node.setNext(head);
            // Make the new node the new head node of the list
            head = newNode;
        }
 // A method that searches for an event based on the event title or contact name
 public Event searchEvent(String title, String name) {
    // Initialize a pointer to the head node of the list
    Node current = head;
    // Loop until the end of the list or a match is found
    while (current != null) {
        // Get the event data from the current node
        Event event = current.getEvent();
        // Check if the event has a matching title and contact name
        if (event.getTitle().equals(title) && event.getContact().getname().equals(name)) {
            // Return that event
            return event;
        }
        // Move the pointer to the next node in the list
        current = current.getNext();
    }
    // No event found with a matching title and contact name
    return null;
}

// A method that deletes all events with a given contact
public void deleteEvents(Contac contact) {
    // Initialize two pointers to keep track of the previous and current nodes in the list
    Node prev = null;
    Node current = head;
    // Loop until the end of the list or all matches are removed
    while (current != null) {
        // Get the event data from the current node
        Event event = current.getevent();
        // Check if the event has a matching contact
        if (event.getContact().equals(contact)) {
            // Remove the current node from the list by linking the previous node to the next node
            if (prev == null) {
                // The current node is the head node, make the next node the new head node
                head = current.getNext();
            } else {
                // The current node is not the head node, make the previous node point to the next node
                prev.setNext(current.getNext());
            }
        } else {
            // The current node does not have a matching contact, move the previous pointer to it
            prev = current;
        }
        // Move the current pointer to the next node in the list
        current = current.getNext();
    }
}
    // Method that returns a string representation of the event
    
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", contact=" + contact +
                '}';
    }


    

