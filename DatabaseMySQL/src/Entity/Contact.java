package Entity;

/**
 *
 * @author Johnny
 */
public class Contact {

    private int id;
    private User owner;
    private User contact;

    public Contact(int id, User owner, User contact) {
        this.id = id;
        this.owner = owner;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getContact() {
        return contact;
    }

    public void setContact(User contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return contact.getNick();
    }
}
