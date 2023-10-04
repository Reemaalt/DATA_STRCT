public class Contact implements Comparable<Contact>{

    
private String name;
private String PhoneNumber;
private String EmailAddr ;
private String Address ;
private String birthday ;
private String notes ;
private LinkedList <Event> Events;



public Contact (String name ,String PhoneNumber ,String EmailAddr ,String Address , String birthday ,String notes ){

    this.name = name ;
    this.PhoneNumber = PhoneNumber ;
    this.EmailAddr = EmailAddr;
    this.Address = Address;
    this.birthday = birthday ;
    this.notes = notes ;
 
}

public String getname(){
    return name;
}


public String getPhoneNumber() {
    return PhoneNumber;
}


public String getEmailAddr() {
    return EmailAddr;
}


public String getAddress() {
    return Address;
}


public String getBirthday() {
    return birthday;
}


public String getNotes() {
    return notes;
}


public void setName(String name) {
    this.name = name;
}


public void setPhoneNumber(String phoneNumber) {
    PhoneNumber = phoneNumber;
}


public void setEmailAddr(String emailAddr) {
    EmailAddr = emailAddr;
}


public void setAddress(String address) {
    Address = address;
}


public void setBirthday(String birthday) {
    this.birthday = birthday;
}


public void setNotes(String notes) {
    this.notes = notes;
}


@Override
public String toString() {
    return "Contact [ name = " + name + ", Phone Number = " + PhoneNumber + ", Email Address = " + EmailAddr + ", Address = " + Address
            + ", Birthday  = " + birthday + ", Notes = " + notes + "]";
}

@Override
public int compareToFirstN(Contact o) {
    //int compareName = this.name.compareToIgnoreCase(o.name);
    contact.getName().equalsIgnoreCase(name);
    return 1;

    
}

public LinkedList <Event> getEvents() {

return Events;
}

 
}