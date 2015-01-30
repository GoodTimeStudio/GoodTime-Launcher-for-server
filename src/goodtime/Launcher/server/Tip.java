package goodtime.Launcher.server;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import javax.swing.JTextPane;
import java.awt.event.MouseEvent;

public class Tip extends JDialog {
	//static Tip dialog;
	static String Newpro;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1050649286143115688L;
	private final JPanel contentPanel = new JPanel();
	static JTextField textField;
	static JTextPane textPane;
	static Tip dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new Tip();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tip() {
		setBounds(100, 100, 400, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textField.setBounds(10, 97, 364, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textPane.setBounds(95, 10, 279, 77);
		textPane.setEditable(false);
		contentPanel.add(textPane);
		textField.setVisible(false);
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		JButton okButton = new JButton("OK");	
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		okButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		
	}
}
