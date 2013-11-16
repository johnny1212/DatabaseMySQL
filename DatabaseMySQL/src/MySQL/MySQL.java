package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Johnny
 */
public class MySQL {

    private Connection connect = null;
    private Statement statement = null;
    String url = "jdbc:mysql://mysql.wu.cz/wu_johnny1212";
    String user = "wu_johnny1212";
    String password = "***";

    private void connect() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void close() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }

    public ResultSet select() throws Exception {
        try {
            if (statement == null) {
                connect();
            }
            if (statement != null) {
                return statement.executeQuery("select * from x_user");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return null;
    }
}
