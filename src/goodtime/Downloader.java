package goodtime;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.List;
import java.awt.Label;

public class Downloader extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6815259848511558127L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Downloader dialog = new Downloader();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Downloader() {
		setTitle("\u6E38\u620F\u4E0B\u8F7D");
		setBounds(100, 100, 670, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Minecraft-GoodTime");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 10, 159, 23);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("\u539F\u7248\u6E38\u620F");
		button.setBackground(Color.WHITE);
		button.setBounds(165, 10, 93, 23);
		contentPanel.add(button);
		
		List list = new List();
		list.setBounds(10, 39, 527, 313);
		contentPanel.add(list);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u8F7D");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(543, 329, 93, 23);
		contentPanel.add(btnNewButton_1);
		
		Label label = new Label("New label");
		label.setBounds(543, 300, 69, 23);
		contentPanel.add(label);
		
		Label label_1 = new Label("New label");
		label_1.setBounds(543, 271, 69, 23);
		contentPanel.add(label_1);
	}
}
