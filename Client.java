public class Client {
    String Name;
    String ID;
    LicenseDetails license;
    ContactDetails contact;

    public Client(String Name , String ID, LicenseDetails license,ContactDetails contact) {
        this.Name = Name;
        this.ID = ID;
        this.license = license;
        this.contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LicenseDetails getLicense() {
        return license;
    }

    public void setLicense(LicenseDetails license) {
        this.license = license;
    }

    public ContactDetails getContact() {
        return contact;
    }

    public void setContact(ContactDetails contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Name='" + Name + '\'' +
                ", ID='" + ID + '\'' +
                ", license='" + license + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
