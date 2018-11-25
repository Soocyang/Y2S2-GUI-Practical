

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryFlagFrame extends JFrame {

    private String host = "jdbc:derby://localhost:1527/countriesdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt = null;

    private JComboBox jcboCountry = new JComboBox();
    private JTextField jtfFullName = new JTextField();
    private JTextField jtfCapital = new JTextField();
    private JLabel jlblFlag = new JLabel();

    public CountryFlagFrame() {
        try{
        initializeDB(); // Connect to DB
        storeDataToTable(); //Store data to the table (including image)
        initializeComboBox(); // Fill in combo box
        retrieveFlagInfo((String) (jcboCountry.getSelectedItem()));
        }catch (Exception e) {
            e.printStackTrace();
        }
        // user interface
        add(jcboCountry, BorderLayout.NORTH);

        JPanel jpCenter = new JPanel(new GridLayout(2, 2));
        jpCenter.add(new JLabel("Official Name"));
        jpCenter.add(jtfFullName);
        jpCenter.add(new JLabel("Capital"));
        jpCenter.add(jtfCapital);
        add(jpCenter, BorderLayout.CENTER);
        jtfFullName.setHorizontalAlignment(SwingConstants.LEFT);

        add(jlblFlag, BorderLayout.EAST);

        jcboCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveFlagInfo((String)jcboCountry.getSelectedItem());
            }
        });
    }

    private void initializeDB() throws Exception {
        
            // Establish connection
            connection = DriverManager.getConnection(host, user, password);
            System.out.println("Database connected");

            // Create a statement for static SQL
            stmt = connection.createStatement();

            // Create a prepared statement to retrieve data
            pstmt = connection.prepareStatement("select * "
                    + "from CountryFlags where name = ?");
    }

    private void storeDataToTable() {
        String[] countries = {"Canada", "UK", "USA", "Germany", "India", "China"};
        String[] countryFullNames = {"Canada", "United Kingdom", "United States of America", "Republic of Germany", "Republic of India", "People''s Republic of China"};
        String[] capitals = {"Ottawa", "London", "Washington D.C.", "Berlin", "New Delhi", "Beijing"};
        String[] imageFilenames = {"/image/canada.gif", "/image/uk.gif",
            "/image/us.gif", "/image/germany.gif", "/image/india.gif",
            "/image/china.gif"};
        try {
            // Create a prepared statement to insert records
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into CountryFlags values(?, ?, ?, ?)");

            // Store all predefined records
            for (int i = 0; i < countries.length; i++) {
                pstmt.setString(1, countries[i]);
                pstmt.setString(2, countryFullNames[i]);
                pstmt.setString(3, capitals[i]);
                // Store image to the table cell
                java.net.URL url
                        = this.getClass().getResource(imageFilenames[i]);
                InputStream inputImage = url.openStream();
                pstmt.setBinaryStream(4, inputImage,
                        (int) (inputImage.available()));

                pstmt.executeUpdate();
            }
            System.out.println("Table CountryFlags populated");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initializeComboBox() throws Exception {
        ResultSet rs = stmt.executeQuery("select name from CountryFlags");
        while (rs.next()) {
            jcboCountry.addItem(rs.getString(1));
        }
    }

    private void retrieveFlagInfo(String name) {
        try {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(4);
                ImageIcon imageIcon = new ImageIcon(
                        blob.getBytes(1, (int) blob.length()));
                jtfFullName.setText(rs.getString(2));
                jtfCapital.setText(rs.getString(3));
                jlblFlag.setIcon(imageIcon);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        CountryFlagFrame frame = new CountryFlagFrame();
        frame.setTitle("Countries of the World");
        frame.setSize(600, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
