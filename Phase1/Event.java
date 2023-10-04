// Event class that represents events or appointments with contacts

public class Event {


    // Fields for the event title, date and time, location, and contact
    private String title;
    private String dateTime;
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
/* 
    public void deleteEvent(Event event) {
        Contact contact = event.getContact();
        if (contacts.contains(contact)) {
            if (contact.removeEvent(event)) {
                System.out.println("Event deleted successfully.");
            } else {
                System.out.println("Event not found for this contact.");
            }
        } else {
            System.out.println("Contact does not exist.");
        }
    }
*/
}

