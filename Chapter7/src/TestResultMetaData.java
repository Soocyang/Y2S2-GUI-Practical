
import java.sql.*;

public class TestResultMetaData {

    public static void main(String[] args) throws SQLException {
        String host = "jdbc:derby://localhost:1527/collegedb";
        String user = "nbuser";
        String password = "nbuser";
        Connection conn = DriverManager.getConnection(host, user, password);

        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println("database URL: " + dbMetaData.getURL());
        System.out.println("database username: " + dbMetaData.getUserName());
        System.out.println("database product name: "
                + dbMetaData.getDatabaseProductName());
        System.out.println("database product version: "
                + dbMetaData.getDatabaseProductVersion());
        System.out.println("JDBC driver name: " + dbMetaData.getDriverName());
        System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
        System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
        System.out.println("JDBC driver minor version: " + dbMetaData.getDriverMinorVersion());
        System.out.println("Max number of connections: " + dbMetaData.getMaxConnections());
        System.out.println("MaxTableNameLentgh: " + dbMetaData.getMaxTableNameLength());
        System.out.println("MaxColumnsInTable: " + dbMetaData.getMaxColumnsInTable());

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Programmes");

        ResultSetMetaData rsMetaData = rs.getMetaData();
        for (int i = 1; i <= rsMetaData.getColumnCount(); ++i) {
            System.out.printf("%-30s\t", rsMetaData.getColumnName(i));
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsMetaData.getColumnCount(); ++i) {
                System.out.printf("%-30s\t", rs.getObject(i));
            }
            System.out.println();
        }
        conn.close();
    }
}
