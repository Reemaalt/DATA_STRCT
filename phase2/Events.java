package phase2;

import java.time.LocalDateTime;

public class Events implements Comparable<Events> {

// Fields for the event 
private String title;
private LocalDateTime dateTime;
private String location;
private String Contactname; 
private boolean isAppointment;


// Constructor  for the events
public Events(String title, LocalDateTime dateTime, String location , boolean isAppointment,String Contactname ) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;

       if( isAppointment)
       {
        this.Contactname=Contactname;
       }
       else{
       involedContacts = new linkedlist<String>();
        String[] names = Contactname.split("\\s*,\\s*"); // Split names by comma and trim spaces
        for (int i = 0; i < names.length; i++) {
            involedContacts.AddContact(names[i]);
        }
    }
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

  

public boolean isAppointment() {
    return isAppointment;
    }


public void setAppointment(boolean isAppointment) {
    this.isAppointment = isAppointment;
    }

    public linkedlist<String> getInvoledContacts() {
    return involedContacts;
}

public void setInvoledContacts(linkedlist<String> involedContacts) {
    this.involedContacts = involedContacts;
}
public String getContactname() {
    return Contactname;
}

public void setContactname(String contactname) {
    Contactname = contactname;
}

private  linkedlist <String> involedContacts ;


    @Override
    public String toString() {
        return "Event title:" + title + ", event date and Time (MM/DD/YYYY HH:MM):" + dateTime + ", event location:" + location + ", Contact name:" +Contactname ;
    }

    @Override
    public int compareTo(Events o) {
        return this.title.compareTo(o.title);
    }
    
}
