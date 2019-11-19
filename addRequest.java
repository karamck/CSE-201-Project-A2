import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Toolkit;

public class addRequest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addRequest frame = new addRequest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addRequest() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(addRequest.class.getResource("AppsyntheIcon.png")));
		setTitle("Add Request");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{188,240};
		gbl_panel.rowHeights = new int[]{41, 50, 50, 50, 50, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSymbol = new JLabel("Symbol");
		lblSymbol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSymbol = new GridBagConstraints();
		gbc_lblSymbol.fill = GridBagConstraints.VERTICAL;
		gbc_lblSymbol.insets = new Insets(0, 0, 5, 5);
		gbc_lblSymbol.gridx = 0;
		gbc_lblSymbol.gridy = 1;
		panel.add(lblSymbol, gbc_lblSymbol);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.VERTICAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		panel.add(lblName, gbc_lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblcurrency = new JLabel("Currency");
		lblcurrency.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblcurrency = new GridBagConstraints();
		gbc_lblcurrency.insets = new Insets(0, 0, 5, 5);
		gbc_lblcurrency.gridx = 0;
		gbc_lblcurrency.gridy = 3;
		panel.add(lblcurrency, gbc_lblcurrency);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStockExchange = new JLabel("Stock Exchange");
		lblStockExchange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblStockExchange = new GridBagConstraints();
		gbc_lblStockExchange.insets = new Insets(0, 0, 5, 5);
		gbc_lblStockExchange.gridx = 0;
		gbc_lblStockExchange.gridy = 4;
		panel.add(lblStockExchange, gbc_lblStockExchange);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		//Message for not filling out fields
		JLabel Msg = new JLabel("");
        Msg.setHorizontalAlignment(SwingConstants.CENTER);
        Msg.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Msg.setForeground(Color.RED);
        
        GridBagConstraints gbc_message = new GridBagConstraints();
        gbc_message.insets = new Insets(0, 0, 5, 0);
        gbc_message.fill = GridBagConstraints.HORIZONTAL;
        gbc_message.gridx = 0;
        gbc_message.gridy = 5;
        panel.add(Msg, gbc_message);
        
        btnNewButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              boolean success = false;
              if (textField.getText().length() == 0 || textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || textField_3.getText().length() == 0) {
                  Msg.setForeground(Color.RED);
                  Msg.setText("Please fill out all fields");
              }
              else {
                  try {
                    success = AddRequestDB.addStock(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
                } catch (IOException e1) {
                    System.out.println("Issue with add stock");
                    Msg.setForeground(Color.RED);
                    Msg.setText("Cannot add, file not found");
                }
                  if (success) {
                      System.out.println("Successful add");
                      dispose();
                  }
                  else {
                      Msg.setForeground(Color.RED);
                      Msg.setText("Stock Could Not Be Added"); 
                  }
              }
                  
          }
        });
	}

}
