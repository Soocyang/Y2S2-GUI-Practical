package comboboxdemo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CountryFrame extends JFrame {

    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private JComboBox jcboCountries = new JComboBox(model);
    private JTextField jtfFullName = new JTextField();
    private JTextField jtfCapital = new JTextField();
    private CountriesDA countriesDA;
    private ArrayList<Country> countries;

    public CountryFrame() {
        countriesDA = new CountriesDA();
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
        setTextFields(countries.get(0));
    }

    private void initializeModel() {
        countries = countriesDA.getCountries();
        for (int i = 0; i < countries.size(); ++i) {
            model.addElement(countries.get(i).getName());
        }
    }

    private void setTextFields(Country country) {
        jtfFullName.setText(country.getFullName());
        jtfCapital.setText(country.getCapital());
    }

    private class SelectCountryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Country country = countries.get(jcboCountries.getSelectedIndex());
            setTextFields(country);
        }
    }
   
    public static void main(String[] args) {
        CountryFrame frame =new CountryFrame();
        frame.setTitle("Countries of the World");
        frame.setSize(600, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
