package comboboxdemo;


import java.sql.*;
import java.util.ArrayList;

public class CountriesDA {

    private String host = "jdbc:derby://localhost:1527/countriesdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Countries";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
    private ResultSet rs;

    public CountriesDA() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public Country getCurrentRecord() {
        Country country = null;
        try {
            country = new Country(rs.getString(1), rs.getString(2), rs.getString(3));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return country;
    }

    public void addRecord(Country country) {
        try {
            stmt.executeUpdate(sqlInsertStr);
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getFullName());
            stmt.setString(3, country.getCapital());
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public ArrayList<Country> getCountries() {

        ArrayList<Country> countries = new ArrayList<Country>();
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                countries.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return countries;
    }
    
    public static void main(String[] args) {
        CountriesDA con = new CountriesDA();
        
        System.out.println(con.getCountries());
    }
}
