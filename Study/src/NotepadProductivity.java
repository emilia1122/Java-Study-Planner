  import java.awt.event.*;
  import javax.swing.*;
  import java.util.*;
  import java.io.*;
  import java.lang.reflect.InvocationTargetException;
  import java.awt.Font;
  import java.awt.Insets;

  public class NotepadProductivity {
   public NotepadProductivity() {
    final JFrame frame = new JFrame("Study Planner");
    final JTextArea txtarea = new JTextArea(5, 5); //pentru notepad
    txtarea.setFont(new Font("Verdana", Font.PLAIN, 15));
    txtarea.setMargin(new Insets(10, 10, 10, 10));
    ImageIcon image = new ImageIcon("C:\\Users\\Hp\\Desktop\\Java\\Study\\bfly.png");

    JScrollPane scroll = new JScrollPane(txtarea);
    final JFileChooser fc = new JFileChooser(); //pentru a selecta fisierul
    JLabel label = new JLabel("Mini Study Planner with Pomodoro Timer To Stop Procrastinating", image,
     JLabel.CENTER); //eticheta principala
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Verdana", Font.PLAIN, 15));
    label.setBounds(10, 10, 700, 46);

    // setari pentru fereastra principala
    frame.setVisible(true);
    frame.setSize(700, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); //centarea ferestrei
    frame.getContentPane().add(label);


    JMenuBar mnu = new JMenuBar();
    frame.setJMenuBar(mnu);

    JMenu list = new JMenu("List");
    list.setMnemonic('L'); //alt L
    JMenu note = new JMenu("Note");
    note.setMnemonic('N');
    JMenu timer = new JMenu("Timer");
    timer.setMnemonic('T');
    JMenu quote = new JMenu("Quote");
    timer.setMnemonic('Q');
    JMenu more = new JMenu("More");



    mnu.add(list);
    mnu.add(note);
    mnu.add(timer);
    mnu.add(quote);
    mnu.add(more);

    JMenuItem listItem = new JMenuItem("New List");
    listItem.setMnemonic('N');
    JMenuItem exit = new JMenuItem("Exit");


    list.add(listItem);
    txtarea.setEditable(false);
    list.addSeparator();
    list.add(exit);


    JMenuItem newItem = new JMenuItem("New Note");
    newItem.setMnemonic('n');
    JMenuItem open = new JMenuItem("Open");
    open.setMnemonic('o');
    JMenuItem save = new JMenuItem("Save");
    save.setMnemonic('s');

    note.add(newItem);
    note.add(open);
    note.add(save);

    JMenuItem newTimer = new JMenuItem("New Timer");
    newTimer.setMnemonic('n');

    timer.add(newTimer);

    JMenuItem newQuote = new JMenuItem("New Quote");
    newQuote.setMnemonic('n');

    quote.add(newQuote);

    JMenuItem about = new JMenuItem("About");


    more.add(about);



    frame.getContentPane().add(scroll);

    // new note 
    newItem.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent ae) {
      JDesktopPane dtp = new JDesktopPane();
         //dtp.setBackground(Color.GREEN);
      frame.setContentPane(dtp);
      dtp.add(txtarea);
      txtarea.setEditable(true);
      txtarea.setText("");
      frame.remove(label);
      frame.setVisible(true);
      
     }
    });

    // pentru a deschide un fisier
    open.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent ae) {
      // ce a selectat utilizatorul va fi preluat de variabila responce
      int responce = fc.showOpenDialog(frame);
      if (responce == JFileChooser.APPROVE_OPTION) {
       File file = fc.getSelectedFile();
       txtarea.setText("");

       try (Scanner in = new Scanner(file)) {
        while ( in .hasNext()) {
         String line = in .nextLine();
         txtarea.append(line + "\n");

        }
       } catch (Exception ex) {}
      }
     }
    });

    save.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
      int responce = fc.showSaveDialog(frame);

      if (responce == JFileChooser.APPROVE_OPTION) {
       File file = fc.getSelectedFile();
       PrintWriter out = null;
       try {
        out = new PrintWriter(file);
        String output = txtarea.getText();
        System.out.println(output);
        out.println(output);


       } catch (FileNotFoundException ex) {} finally {
        out.flush();
        out.close();
       }
      }
     }
    });


    exit.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent ae) {
      System.exit(0);
     }
    });
    listItem.addActionListener(new ActionListener() {


     @Override
     public void actionPerformed(ActionEvent ae) {
      txtarea.setEditable(false);
      new ListTo();

     }
    });

    newTimer.addActionListener(new ActionListener() {


     @Override
     public void actionPerformed(ActionEvent ae) {
      txtarea.setEditable(true);
      txtarea.setText("");
      frame.remove(label);
      new CountDown();
     }
    });

    newQuote.addActionListener(new ActionListener() {


     @Override
     public void actionPerformed(ActionEvent ae) {
      txtarea.setEditable(true);
      txtarea.setText("");
      frame.remove(label);
      new Quote();
     }
    });

    about.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
      JDesktopPane dtp = new JDesktopPane();
      //dtp.setBackground(Color.GREEN);
      frame.setContentPane(dtp);
      JInternalFrame compFrame = new JInternalFrame("About", true,
       true, true, true);
      JLabel composer = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do.");
      composer.setHorizontalAlignment(SwingConstants.CENTER);
      compFrame.setContentPane(composer);
      compFrame.setSize(100, 100);
      compFrame.setLocation(100, 10);
      compFrame.setVisible(true);
      dtp.add(compFrame);
    


      JInternalFrame listFrame = new JInternalFrame("Help", true, true,
       true, true);
      JLabel list = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do.");
      list.setHorizontalAlignment(SwingConstants.CENTER);
      listFrame.setContentPane(list);
      listFrame.setLocation(210, 10);
      listFrame.setSize(100, 100);
      listFrame.setVisible(true);
      dtp.add(listFrame);

      JInternalFrame mboxFrame = new JInternalFrame("Contact", true,
       true, true, true);
      JLabel reader = new JLabel("Send an email at: test@yahoo.com");
      reader.setHorizontalAlignment(SwingConstants.CENTER);
      mboxFrame.setContentPane(reader);
      mboxFrame.setSize(100, 100);
      mboxFrame.setLocation(320, 10);
      mboxFrame.setVisible(true);
      dtp.add(mboxFrame);
      
      compFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      mboxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      


     }
    });


}
public static void main(String arg[]) {
    try {
     SwingUtilities.invokeAndWait(new Runnable() {
      @Override
      public void run() {
       new NotepadProductivity();

      }
     });
    } catch (InterruptedException | InvocationTargetException e) {}
   }

  }