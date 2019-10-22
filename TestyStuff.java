import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.JScrollPane;

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
        contentPane.setLayout(new BorderLayout(10, 10));
        
        JPanel browser_panel = new JPanel();
        contentPane.add(browser_panel);
        browser_panel.setLayout(new BoxLayout(browser_panel, BoxLayout.Y_AXIS));
        
        JLabel browserLabel = new JLabel("New label");
        browser_panel.add(browserLabel);
        
        ListModel<String> bigData = new AbstractListModel<String>() {
            public int getSize() { return Short.MAX_VALUE; }
            public String getElementAt(int index) { return "TestObj " + index; }
        };
        
        JScrollPane scrollPane = new JScrollPane();
        browser_panel.add(scrollPane);
        
        JPanel panel_2 = new JPanel();
        scrollPane.setViewportView(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JList<String> stocklist = new JList<String>(bigData);
        panel_2.add(stocklist);
        
        JPanel topbar = new JPanel();
        contentPane.add(topbar, BorderLayout.NORTH);
        topbar.setLayout(new BoxLayout(topbar, BoxLayout.X_AXIS));
        
        JPanel panelRight = new JPanel();
        topbar.add(panelRight);
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        JLabel lblStockItTo = new JLabel("Stock It To Me");
        panelRight.add(lblStockItTo);
        
        JPanel panel_1 = new JPanel();
        topbar.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        
        JButton btnLogin = new JButton("Login");
        panel_1.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener()
	    {
  	      public void actionPerformed(ActionEvent e)
  	      {
  	        login l = new login();
  	        l.setVisible(true);
  	      }
  	    });
        
        JButton btnSignup = new JButton("Signup");
        panel_1.add(btnSignup);
        
        JPanel sidebar = new JPanel();
        contentPane.add(sidebar, BorderLayout.EAST);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        
        JLabel sidebarLabel = new JLabel("New label");
        sidebar.add(sidebarLabel);
        
        JSeparator separator_1 = new JSeparator();
        sidebar.add(separator_1);
        
        JList<Stock> sidebarlist = new JList<Stock>();
        sidebar.add(sidebarlist);
    }
}
