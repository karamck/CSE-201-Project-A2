import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class TestyStuff extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestyStuff frame = new TestyStuff();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); //comment
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TestyStuff() {
    	setTitle("Stock It To Me");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 723, 610);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel Bowse_panel = new JPanel();
        contentPane.add(Bowse_panel);
        Bowse_panel.setLayout(new BoxLayout(Bowse_panel, BoxLayout.X_AXIS));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        Bowse_panel.add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel lblStockBowse_1 = new JLabel("Stock Bowse");
        scrollPane.setColumnHeaderView(lblStockBowse_1);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JSplitPane splitPane = new JSplitPane();
        panel.add(splitPane);
        
        JPanel panel_1 = new JPanel();
        splitPane.setRightComponent(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        
        JButton btnLogin = new JButton("Login");
        panel_1.add(btnLogin);
        
        JButton btnSignup = new JButton("Signup");
        panel_1.add(btnSignup);
        
        JPanel panel_2 = new JPanel();
        splitPane.setLeftComponent(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        JLabel lblStockItTo = new JLabel("Stock It To Me");
        panel_2.add(lblStockItTo);
        
        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setVgap(15);
        flowLayout.setHgap(15);
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel_3, BorderLayout.EAST);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        panel_3.add(scrollPane_1);
    }

}
