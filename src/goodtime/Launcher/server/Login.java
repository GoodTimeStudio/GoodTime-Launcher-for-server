package goodtime.Launcher.server;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6391860734540961849L;
	private final JPanel contentPanel = new JPanel();
	static JTextField textField;
	static JPasswordField passwordField;
	static Login dialog = new Login();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("\u767B\u5F55");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u5F55\u65B9\u5F0F:");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label.setBounds(10, 10, 54, 15);
		contentPanel.add(label);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		comboBox.setBounds(74, 10, 249, 21);
		contentPanel.add(comboBox);
		comboBox.addItem("µÁ°æµÇÂ¼");
		comboBox.addItem("GoodTime·þÎñÆ÷µÇÂ¼");
		comboBox.addItem("MoJangÕý°æµÇÂ¼");
		
		JLabel label_1 = new JLabel("\u73A9\u5BB6\u540D\u5B57:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_1.setBounds(10, 60, 70, 15);
		contentPanel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(90, 60, 118, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 90, 54, 15);
		contentPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 90, 118, 21);
		contentPanel.add(passwordField);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ConfigJson.username = textField.getText();
				ConfigJson.password = passwordField.getText();
				ConfigJson.saveLogin();
				dialog.dispose();
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton.setBounds(230, 60, 93, 49);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u76D7\u7248\u767B\u5F55\u65E0\u6CD5\u8FDB\u5165GoodTime\u670D\u52A1\u5668");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 204, 414, 15);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 229, 118, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7ED1\u5B9A\u6B63\u7248\u8D26\u53F7");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_2.setBounds(145, 229, 118, 23);
		contentPanel.add(btnNewButton_2);
		
		lblNewLabel.setVisible(false);
		passwordField.setVisible(false);
		
		ConfigJson.loadLogin();
		textField.setText(ConfigJson.object.getString("name"));	
		passwordField.setText(ConfigJson.object.getString("password"));
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedItem() == "MoJangÕý°æµÇÂ¼") {
					lblNewLabel.setVisible(true);
					passwordField.setVisible(true);
					btnNewButton.setText("µÇÂ¼");
				} else if (comboBox.getSelectedItem() == "GoodTime·þÎñÆ÷µÇÂ¼") {
					lblNewLabel.setVisible(true);
					passwordField.setVisible(true);
					btnNewButton.setText("µÇÂ¼");
				} else {
					lblNewLabel.setVisible(false);
					passwordField.setVisible(false);
					btnNewButton.setText("±£´æ");
				}
			}
		});
	}
}
