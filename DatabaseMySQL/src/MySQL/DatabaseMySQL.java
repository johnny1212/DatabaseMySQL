/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import Entity.Contact;
import Entity.Message;
import Entity.Role;
import Entity.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class DatabaseMySQL {

    public List<User> getUsers() {
        MySQL database = new MySQL();
        List<User> users = new ArrayList<User>();
        try {

            ResultSet rs = database.select("SELECT * from x_user,x_role where x_user.role_id=x_role.id;");
            while (rs.next()) {
                users.add(new User(rs.getInt("x_user.id"), rs.getString("x_user.nick"), rs.getString("x_user.password"), new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev"))));
            }
        } catch (Exception e) {
            System.out.println("err");
        } finally {
            database.close();
        }
        return users;
    }

    public List<Contact> getContactList(int owner_id) {
        MySQL database = new MySQL();
        List<Contact> users = new ArrayList<Contact>();
        try {
            User owner = getUser(owner_id);
            if (owner != null) {
                ResultSet rs = database.select("SELECT * FROM x_contact, x_user,x_role WHERE x_contact.owner_id=" + owner_id + " and x_contact.contact_id=x_user.id and x_user.role_id=x_role.id;");
                while (rs.next()) {
                    users.add(new Contact(rs.getInt("x_contact.id"),
                            owner,
                            new User(rs.getInt("x_user.id"), rs.getString("x_user.nick"), rs.getString("x_user.password"), new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev")))));
                }
            }
        } catch (Exception e) {
            System.out.println("err");
        } finally {
            database.close();
        }
        return users;
    }

    public User getUser(int id) {
        MySQL database = new MySQL();
        User user = null;
        try {
            ResultSet rs = database.select("SELECT * from x_user,x_role where x_user.role_id=x_role.id and x_user.id='" + id + "';");
            if (rs.next()) {
                user = new User(rs.getInt("x_user.id"), rs.getString("x_user.nick"), rs.getString("x_user.password"), new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev")));
            }
        } catch (Exception e) {
            System.out.println("err");
        } finally {
            database.close();
        }
        return user;
    }

    public User getUser(String nick) {
        MySQL database = new MySQL();
        User user = null;
        try {
            ResultSet rs = database.select("SELECT * from x_user,x_role where x_user.role_id=x_role.id and x_user.nick='" + nick + "';");
            if (rs.next()) {
                user = new User(rs.getInt("x_user.id"), rs.getString("x_user.nick"), rs.getString("x_user.password"), new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev")));
            }
        } catch (Exception e) {
            System.out.println("err");
        } finally {
            database.close();
        }
        return user;
    }

    public List<Message> getMessages(int owner_id, int to_id) {
        MySQL database = new MySQL();
        List<Message> messages = new ArrayList<Message>();
        try {
            User owner = getUser(owner_id);
            if (owner != null) {
                ResultSet rs = database.select("SELECT * FROM x_message, x_user,x_role WHERE (x_message.owner_id=" + owner_id + " or x_message.owner_id=" + to_id + ") and (x_message.to_id=" + owner_id + " or x_message.to_id=" + to_id + ") and x_message.to_id=x_user.id and x_user.role_id=x_role.id order by x_message.when limit 10;");
                while (rs.next()) {
                    messages.add(new Message(rs.getInt("x_message.id"), owner,
                            new User(rs.getInt("x_user.id"), rs.getString("x_user.nick"), rs.getString("x_user.password"), new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev"))),
                            rs.getString("x_message.text"), rs.getTimestamp("x_message.when"), rs.getBoolean("x_message.read")));
                }
            }
        } catch (Exception e) {
            System.out.println("err");
        } finally {
            database.close();
        }
        return messages;
    }
    /*public Role getRole(int id) {
     MySQL database = new MySQL();
     Role role = null;
     try {

     ResultSet rs = database.select("SELECT * from x_role where id='" + id + "';");
     if (rs.next()) {
     role = new Role(rs.getInt("x_role.id"), rs.getString("x_role.nazev"));
     }
     } catch (Exception e) {
     System.out.println("err");
     } finally {
     database.close();
     }
     return role;
     }*/
}
