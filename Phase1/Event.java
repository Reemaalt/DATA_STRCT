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

    

    // Method that returns a string representation of the event
    
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", contact=" + contact +
                '}';
    }
}

    

