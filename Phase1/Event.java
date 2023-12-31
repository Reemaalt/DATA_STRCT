
/*Event: This class will represent events or appointment that can be scheduled with a contact. It
should have fields for the event title, date and time, location, and the contact involved in this
event.*/
import java.time.LocalDateTime;
 public class Event {

// Fields for the event 
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

    public void setDateTime( LocalDateTime dateTime) {
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

    @Override
    public String toString() {
        return "Event title:" + title + ", event date and Time (MM/DD/YYYY HH:MM):" + dateTime + ", event location:" + location + ", Contact name:" + Contact.getname()
                ;
    }

    public int compareTo(Event o) {
 
        return(this.title.compareTo(o.title)) ;
        
     }

}

