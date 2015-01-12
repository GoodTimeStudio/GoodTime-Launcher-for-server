package goodtime;

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

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6391860734540961849L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
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
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		comboBox.setBounds(74, 10, 134, 21);
		contentPanel.add(comboBox);
		comboBox.addItem("µÁ°æµÇÂ¼");
		comboBox.addItem("GoodTime·þÎñÆ÷µÇÂ¼");
		comboBox.addItem("MoJangÕý°æµÇÂ¼");
		
		JLabel label_1 = new JLabel("\u73A9\u5BB6\u540D\u5B57:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_1.setBounds(10, 60, 70, 15);
		contentPanel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(90, 57, 118, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 90, 54, 15);
		contentPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 90, 118, 21);
		contentPanel.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton.setBounds(230, 60, 93, 49);
		contentPanel.add(btnNewButton);
	}
}
