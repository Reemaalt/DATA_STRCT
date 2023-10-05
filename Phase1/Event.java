
/*Event: This class will represent events or appointment that can be scheduled with a contact. It
should have fields for the event title, date and time, location, and the contact involved in this
event.*/

 public class Event {

// Fields for the event 
private String title;
private String dateTime;
private String location;
private Contact Contact;

// Constructor 
    public Event(String title, String dateTime, String location, Contact contact) {
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime( String dateTime) {
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

}

