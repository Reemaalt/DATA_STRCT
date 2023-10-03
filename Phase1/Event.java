// Event class that represents events or appointments with contacts
import java.time.LocalDateTime;
public class Event {


    // Fields for the event title, date and time, location, and contact
    private String title;
    private LocalDateTime dateTime;
    private String location;
    private Contact Contact;

    // Constructor 
    public Event(String title, LocalDateTime dateTime, String location, Contact contact) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
        this.Contact = contact;
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

    public Contact getContact() {
        return Contact;
    }

    public void setContact(Contact contact) {
        this.Contact = contact;
    }

    // Method that compares events by their titles alphabetically

    public int compareTo(Event other) {
        return this.title.compareTo(other.title);
    }
}

