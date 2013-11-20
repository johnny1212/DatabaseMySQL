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
    private String url = "jdbc:mysql://sql3.freesqldatabase.com/sql323113";
    private String user = "sql323113";
    private String password = "***";

    public MySQL() {
        password = Pass.getPass();
    }

    private void connect() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
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

    public ResultSet select(String query) throws Exception {
        try {
            if (statement == null) {
                connect();
            }
            if (statement != null) {
                return statement.executeQuery(query);
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
