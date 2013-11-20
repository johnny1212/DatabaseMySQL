package databasemysql;

import CentralSystem.CentralSystem;
import Entity.Contact;
import Entity.Role;
import Entity.User;
import MySQL.DatabaseMySQL;
import java.util.List;

/**
 *
 * @author Johnny
 */
public class MainDatabaseMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseMySQL db = new DatabaseMySQL();
        CentralSystem system = new CentralSystem();
        /*List<User> users;
         users = db.getUsers();
         for (User user : users) {
         System.out.println(user.toString());
         }*/
        /*User user = db.getUser(1);
         System.out.println(user.toString());*/
        /*Role role = db.getRole(1);
         System.out.println("role: " + role.toString());*/
        boolean log = system.logIn("admin", "adminadmin");
        System.out.println("Log: " + log);
        List<Contact> contactList = system.getContactList();
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
    }
}
