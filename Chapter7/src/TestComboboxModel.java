import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestComboboxModel extends JFrame{
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    
    private JComboBox jcboSoftware = new JComboBox(model);
    private JList jlstSoftware = new JList(model);
  
    private JButton jbtAdd = new JButton("Add new software");
    public TestComboboxModel(){
        model.addElement("SQL Server");
        model.addElement("VS 2013");
        
        add(jcboSoftware, BorderLayout.EAST);
        add(new JScrollPane(jlstSoftware), BorderLayout.WEST);
        add(jbtAdd, BorderLayout.SOUTH);
        jbtAdd.addActionListener(new AddListerner());
          setTitle("Testing DefaultComboBoxModel");
        //  pack();
       setSize(300, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public class AddListerner implements ActionListener{
        public void actionPerformed(ActionEvent e){
            model.addElement("Microsoft Excel");
            model.insertElementAt("Microsoft Server 2012",2);
            model.removeElement("SQL Server");
        }
    }
    public static void main(String[] args) {
        new TestComboboxModel();
    }
    
}
