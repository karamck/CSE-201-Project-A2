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
        contentPane.add(Bowse_panel, BorderLayout.CENTER);
        Bowse_panel.setLayout(new BoxLayout(Bowse_panel, BoxLayout.X_AXIS));
        
        JScrollPane scrollPane = new JScrollPane();
        Bowse_panel.add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel lblStockBowse_1 = new JLabel("Stock Bowse");
        scrollPane.setColumnHeaderView(lblStockBowse_1);
        
        JPanel StockPanel = new JPanel();
        scrollPane.setViewportView(StockPanel);
        
        JSplitPane splitPane = new JSplitPane();
        StockPanel.add(splitPane);
        
        JPanel panel = new JPanel();
        splitPane.setLeftComponent(panel);
        
        JSplitPane splitPane_1 = new JSplitPane();
        splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        panel.add(splitPane_1);
        
        JLabel lblStockName = new JLabel("Stock Name");
        splitPane_1.setLeftComponent(lblStockName);
        
        JLabel lblStockAbb = new JLabel("Stock Abb");
        splitPane_1.setRightComponent(lblStockAbb);
        
        JPanel panel_1 = new JPanel();
        splitPane.setRightComponent(panel_1);
        
        JLabel lblStockInfo = new JLabel("Stock Info");
        panel_1.add(lblStockInfo);
    }

}
