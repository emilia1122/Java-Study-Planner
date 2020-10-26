import javax.swing.*;    
import java.awt.event.*;
import java.awt.Color;    
class  Quote  {    
JFrame f;    
Quote(){    
    f = new JFrame("Today Quote");   
    final JLabel label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setLocation(10, 0);
    label.setSize(690, 250);  
    label.setForeground(Color.BLACK);
    label.setBackground(Color.ORANGE);
    JButton b = new JButton("Show");  
    b.setBounds(50, 50, 75, 20);  
    String languages[] = {"Change the world by being yourself.","Every moment is a fresh beginning.","What we think, we become.","Determine your priorities and focus on them.","Reality is wrong, dreams are for real.", "Strive for greatness.", "And still, I rise.", "Yesterday you said tomorrow. Just do it."};         
    final JComboBox<?> cb = new JComboBox<Object>(languages);    
    cb.setBounds(50, 20, 300, 20);    
    f.getContentPane().add(cb); f.getContentPane().add(label); f.getContentPane().add(b);    
    f.getContentPane().setLayout(null);    
    f.setSize(700, 300);    
    f.setLocationRelativeTo(null);  
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setVisible(true);       
    b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {       
String data = "Quote: "   
   + cb.getItemAt(cb.getSelectedIndex());  
label.setText(data);  
}  
});           
}    
/**
 * @wbp.parser.entryPoint
 */
public static void main(String[] args) {    
        
}    
}    
