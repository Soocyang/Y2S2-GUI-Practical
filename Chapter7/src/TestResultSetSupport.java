
import java.sql.*;

public class TestResultSetSupport {

    public static void main(String[] args) throws SQLException {
        String host = "jdbc:derby://localhost:1527/collegedb";
        String user = "nbuser";
        String password = "nbuser";
        Connection conn = DriverManager.getConnection(host, user, password);

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("database product name: "
                + dbMetaData.getDatabaseProductName());
        System.out.println("database product version: "
                + dbMetaData.getDatabaseProductVersion());
        System.out.println("JDBC driver name: " + dbMetaData.getDriverName());
        System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
        System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
        System.out.println("JDBC driver minor version: " + dbMetaData.getDriverMinorVersion());
        System.out.println("\nSupports resultSetTypes: ");
        System.out.println("\tTYPE_FORWARD_ONLY? " + dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
        System.out.println("\tTYPE_SCROLL_INSENSITIVE? " + dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println("\tTYPE_SCROLL_SENSITIVE? " + dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        
        System.out.println("\nSupports resultSetConcurrency: ");
        System.out.println("\tTYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY? " + dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        System.out.println("\tTYPE_SCROLL_INSENSITIVE, CONCUR_UPDATABLE? " + dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
        System.out.println("\tTYPE_SCROLL_SENSITIVE, CONCUR_UPDATABLE? " + dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
        
    }
}
