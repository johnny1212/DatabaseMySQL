package databasemysql;

import MySQL.MySQL;
import java.sql.ResultSet;

/**
 *
 * @author Johnny
 */
public class DatabaseMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQL database = new MySQL();
        try {

            ResultSet rs = database.select("SELECT * from x_user;");
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
            database.close();
        } catch (Exception e) {
            System.out.println("err");
        }
    }
}
