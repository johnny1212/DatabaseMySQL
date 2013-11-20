package CentralSystem;

import Entity.Contact;
import Entity.Message;
import Entity.User;
import MySQL.DatabaseMySQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class CentralSystem {

    private DatabaseMySQL db = new DatabaseMySQL();
    private User user = null;
    private boolean loged = false;

    public boolean logIn(String nick, String password) {
        User u = db.getUser(nick);
        if (u.getNick().equals(nick) && u.getPassword().equals(password)) {
            user = u;
            loged = true;
            return true;
        }
        return false;
    }

    public List<Contact> getContactList() {
        if (!loged) {
            return new ArrayList<Contact>();
        }
        return db.getContactList(user.getId());
    }

    public List<Message> getMessages(User to) {
        return db.getMessages(user.getId(), to.getId());
    }

    public User getUser() {
        return user;
    }

    public boolean isLoged() {
        return loged;
    }
}
