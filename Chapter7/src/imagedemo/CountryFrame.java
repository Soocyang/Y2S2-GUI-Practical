package imagedemo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CountryFrame extends JFrame {

    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private JComboBox jcboCountries = new JComboBox(model);
    private JTextField jtfFullName = new JTextField();
    private JTextField jtfCapital = new JTextField();
    private JLabel jlblFlag = new JLabel();
    private CountriesDA countriesDA;
    private ArrayList<Country> countries;

    public CountryFrame() {
        countriesDA = new CountriesDA();
        initializeTable();  
        initializeModel();
        add(jcboCountries, BorderLayout.NORTH);
        jcboCountries.addActionListener(new SelectCountryListener());

        JPanel jpCenter = new JPanel(new GridLayout(2, 2));
        jpCenter.add(new JLabel("Official Name"));
        jpCenter.add(jtfFullName);
        jpCenter.add(new JLabel("Capital"));
        jpCenter.add(jtfCapital);
        add(jpCenter);
        jtfFullName.setHorizontalAlignment(SwingConstants.LEFT);
        setFields(countries.get(0));

        add(jlblFlag, BorderLayout.EAST);
    }

    private void initializeModel() {
        countries = countriesDA.getCountries();
        for (int i = 0; i < countries.size(); ++i) {
            model.addElement(countries.get(i).getName());
        }
    }

    private void initializeTable() {
        String[] countryNames = {"Canada", "UK", "USA", "Germany", "India", "China"};
        String[] countryFullNames = {"Canada", "United Kingdom", "United States of America", "Republic of Germany", "Republic of India", "People''s Republic of China"};
        String[] capitals = {"Ottawa", "London", "Washington D.C.", "Berlin", "New Delhi", "Beijing"};
        String rootPath = "/image/";
        String[] imageFilenames = {"Canada.gif", "UK.gif", "US.gif", "Germany.gif", "India.gif", "China.gif"};

        try {
            for (int i = 0; i < countryNames.length; ++i) {
                ImageIcon imageIcon = new ImageIcon(rootPath + imageFilenames[i], rootPath + imageFilenames[i]);
                Country c = new Country(countryNames[i], countryFullNames[i], capitals[i], imageIcon);
                countriesDA.addRecord(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setFields(Country country) {
        jtfFullName.setText(country.getFullName());
        jtfCapital.setText(country.getCapital());
        jlblFlag.setIcon(country.getFlag());
    }

    private class SelectCountryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Country country = countries.get(jcboCountries.getSelectedIndex());
            setFields(country);
        }
    }

    public static void main(String[] args) {
        CountryFrame frame = new CountryFrame();
        frame.setTitle("Countries of the World");
        frame.setSize(600, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
