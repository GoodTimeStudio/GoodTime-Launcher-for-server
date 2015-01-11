package goodtime;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Error extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3488846941558750511L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Error dialog = new Error();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Error() {
		setTitle("\u9519\u8BEF\u62A5\u544A");
		setBounds(100, 100, 617, 408);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(0, 79, 601, 248);
			contentPanel.add(textPane);
		}
		
		JLabel lblNewLabel = new JLabel("\u54CE\u5440\uFF01GoodTime-Laucnher\u5D29\u6E83\u4E86");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(90, 10, 283, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u9519\u8BEF\u5185\u5BB9");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(90, 40, 501, 15);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton button = new JButton("\u53CD\u9988\u9519\u8BEF");
			button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
			buttonPane.add(button);
			{
				JButton cancelButton = new JButton("\u597D\u5427");
				cancelButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
