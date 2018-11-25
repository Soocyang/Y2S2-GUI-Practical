package imagedemo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class CountriesDA {

    private String host = "jdbc:derby://localhost:1527/countriesdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CountryFlags";
    private Connection conn;
    private PreparedStatement stmt;
    private String sqlQueryStr = "SELECT * from " + tableName;
    private String sqlInsertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?)";
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
            Blob blob = rs.getBlob(4);
            ImageIcon imageIcon = new ImageIcon(blob.getBytes(1, (int) blob.length()));
            country = new Country(rs.getString(1), rs.getString(2), rs.getString(3), imageIcon);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return country;
    }

    public void addRecord(Country country) {
        try {
            stmt = conn.prepareStatement(sqlInsertStr);
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getFullName());
            stmt.setString(3, country.getCapital());

            java.net.URL url = getClass().getResource(country.getFlag().getDescription());
            InputStream inputImage = url.openStream();
            stmt.setBinaryStream(4, inputImage, (int)(inputImage.available()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (IOException ex) {
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
}
