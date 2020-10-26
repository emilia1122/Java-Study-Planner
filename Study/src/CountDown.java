import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CountDown {

   
    public CountDown() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               

                JFrame frame = new JFrame("Pomodoro Timer");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                JInternalFrame jif = new JInternalFrame();
                frame.add(jif);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Timer timer;
        private long startTime = -1;
        private long duration = 1500000; //25 de minute, dupa tehnica pomodoro

        private JLabel label;

        public TestPane() {
            setLayout(new GridBagLayout());
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    long clockTime = now - startTime;
                    if (clockTime >= duration) {
                        clockTime = duration;
                        timer.stop();
                    }
                    SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
                    label.setText(df.format(duration - clockTime));
                }
            });
            timer.setInitialDelay(0);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!timer.isRunning()) {
                        startTime = -1;
                        timer.start();
                    }
                }
            });
            label = new JLabel("Click to start");
            label.setFont(new Font("Verdana", Font.PLAIN, 22));
            add(label);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(700, 200);
        }

    }

}