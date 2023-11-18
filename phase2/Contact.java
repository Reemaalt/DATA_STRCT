package phase2;





// Contact class representing a single contact in the phonebook
class Contact implements Comparable<Contact> {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    private linkedlist <Events> EventsAndAppointments;
    

    
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
            String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
         this.EventsAndAppointments = new linkedlist<Events>();
    }
    
//add events to EventsAndAppointments




    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.getName());
    }

    public int compareToPhone(String PhoneNum) {
            return (this.phoneNumber.compareToIgnoreCase(PhoneNum));
    }

    @Override
    public String toString() {
        return "Contact /n Name : " + name + " /n Phone Number : " + phoneNumber + "/n Email Address : " + emailAddress
                + "/n Address : " + address + "/n Birthday : " + birthday + "/n Notes : " + notes ;
    }

   
    
}
