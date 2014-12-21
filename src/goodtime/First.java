package goodtime;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class First extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	static First dialog = new First();

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
	 *Create the dialog.
	 */
	public First() {
		setTitle("\u7B2C\u4E00\u6B21\u8FD0\u884C");
		setBounds(100, 100, 461, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 27, 54, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u6E38\u620F\u540D\u5B57");
		label_1.setBounds(10, 10, 70, 15);
		contentPanel.add(label_1);
		
		textField = new JTextField();//用户名
		textField.setBounds(81, 7, 92, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//密码
		textField_1.setBounds(81, 43, 92, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(10, 49, 54, 15);
		contentPanel.add(label_2);
		
		JButton button = new JButton("\u5B8C\u6210\u8BBE\u7F6E");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent arg0)//鼠标单机保存设置
			{
				String username = textField.getText();
				String password = textField_1.getText();
				Config.WriteConfig();
				dialog.dispose();
				CoreGui frame = new CoreGui();
				frame.setVisible(true);
			}
		});
		button.setBounds(311, 86, 124, 52);
		contentPanel.add(button);
	}
}
