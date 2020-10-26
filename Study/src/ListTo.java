import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

class ListTo extends JFrame implements ActionListener {

 private static final long serialVersionUID = 1L;
 JList < Object > l1;
 JTextField t1;
 JButton b1, b2, b3;
 int ret;
 DefaultListModel < Object > listModel;
 private JRadioButton radio1 = null;
 private JRadioButton radio2 = null;
 private JRadioButton radio3 = null;

 ListTo() {
  setTitle("Study List");
  getContentPane().setLayout(new FlowLayout());
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //pentru a inchide doar fereastra curenta, nu si cea principala
  setLocationRelativeTo(null);  
  listModel = new DefaultListModel < Object > ();
  radio1 = new JRadioButton("Urgent");
  radio1.setForeground(new Color(255, 255, 255));
  radio1.setBackground(new Color(255, 69, 0));
  radio2 = new JRadioButton("Over 2 hours");
  radio2.setBackground(new Color(0, 0, 255));
  radio2.setForeground(new Color(255, 255, 255));
  radio3 = new JRadioButton("Under 5 minutes");
  radio3.setForeground(new Color(255, 255, 255));
  radio3.setBackground(new Color(255, 105, 180));
  ButtonGroup group = new ButtonGroup(); //pentru a selecta doar 1
  group.add(radio1);
  group.add(radio2);
  group.add(radio3);



 
  // J List
  l1 = new JList < Object > (listModel);
  l1.setLayoutOrientation(JList.VERTICAL_WRAP);
  l1.setFont(new Font("Verdana", Font.PLAIN, 14));
  
  // Text Field
  t1 = new JTextField(10);
  t1.setFont(new Font("Verdana", Font.PLAIN, 11));
  
  
  // Buttons
  b1 = new JButton("Add");
  b1.addActionListener(this);
  b2 = new JButton("Remove");
  b2.addActionListener(this);
  b2.setActionCommand("remove");
  b3 = new JButton("Clear All");
  b3.addActionListener(this);
  b3.setActionCommand("clear");

  
  
  JScrollPane js = new JScrollPane(l1);
  js.setPreferredSize(new Dimension(300, 100));
  getContentPane().add(js);
  getContentPane().add(t1);
  getContentPane().add(b1);
  getContentPane().add(b2);
  getContentPane().add(b3);
  getContentPane().add(radio1);
  getContentPane().add(radio2);
  getContentPane().add(radio3);
  setSize(700, 300);
  setVisible(true);
 

  
  radio1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == radio1)
            setTitle("Urgent");
    
          

      }
  });
  radio2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == radio2)
            setTitle("Over 2 hours");

      }
  });
  radio3.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == radio3)
            setTitle("Under 5 minutes");

      }
  });
 }

 public void actionPerformed(ActionEvent ae) {
  if ("clear".equals(ae.getActionCommand())) {
   listModel.removeAllElements();

  } else if ("remove".equals(ae.getActionCommand())) {
   ret = l1.getSelectedIndex();
   listModel.remove(ret);
  } else {
   String select = t1.getText();
   Object obj = select;
   listModel.add(0, obj);

  }
  
 

 
}

}
