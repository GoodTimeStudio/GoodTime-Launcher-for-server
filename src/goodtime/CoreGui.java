package goodtime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JComboBox;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.ScrollPane;



public class CoreGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int getid = 0; 
	static String ggetid = "0";
	static JComboBox<Object> comboBox = new JComboBox<Object>();
	static JLabel lblNewLabel = new JLabel();
	static JLabel label_1;
	/*
	 * ±³¾°²âÊÔ
	 */
	//private JPanel imagePanel;
	//private ImageIcon background;
	
	 /* 
	 */
	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) 
	{		
		ConfigJson.Check();			
	}


	/**
	 * Create the frame.
	 */
	public CoreGui() {
		setTitle("GoodTime-Launcher Dev 1501c");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JButton btnNewButton_2 = new JButton("\u79BB\u7EBF\u6E38\u620F");
		btnNewButton_2.setBounds(379, 508, 167, 84);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			//-------------------------------------------
			public void mouseClicked(MouseEvent arg0) {
				//Æô¶¯
				try 
				{
					getid = comboBox.getSelectedIndex();
					ggetid = String.valueOf(getid); 
					Object gver = comboBox.getSelectedItem();
					Info.version = gver.toString();
					ConfigJson.save();
					Info.main(null);
					try {
						Launcher.main(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.exit(0);
				} 
				catch (JsonIOException e) {
					e.printStackTrace();
				} catch (JsonSyntaxException e) {
					e.printStackTrace();
				}
			}
			//-------------------------------------------
		});
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("\u7BA1\u7406\u914D\u7F6E");
		btnNewButton.setBounds(10, 571, 110, 21);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//-------------------
				try {
					Options.main(null);
					Options.textField_1.setText((String) comboBox.getSelectedItem());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("ºÚÌå", Font.PLAIN, 14));
		
		
	/*/±³¾°--------------------------------------
		
		URL bgtp = this.getClass().getResource("bg.jpg");
		System.out.println(bgtp);
		background = new ImageIcon(bgtp);// ±³¾°Í¼Æ¬
		JLabel bg = new JLabel(background);
		bg.setBounds(0, 0, background.getIconWidth(),
		background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().setLayout(null);
		  // °Ñ±³¾°Í¼Æ¬Ìí¼Óµ½·Ö²ã´°¸ñµÄ×îµ×²ã×÷Îª±³¾°
		this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setResizable(false);
		
		
		//=============================*/
		//Info.getVersion();
		ConfigJson.load();
		//getid = Integer.valueOf(ggetid).intValue();
		comboBox.setBounds(10, 508, 230, 21);
		contentPane.add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ" ,Font.PLAIN,12));
		//comboBox.setSelectedIndex(getid);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				label_1.setText("¼´½«¿ªÊ¼"+comboBox.getSelectedItem());
			}
		});
		

		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 918, 498);
		contentPane.add(tabbedPane);	
		tabbedPane.setVisible(true);

		tabbedPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		ScrollPane scrollPane = new ScrollPane();
		tabbedPane.addTab("¸üÐÂÈÕÖ¾", null, scrollPane, null);

		JEditorPane editorPane = new JEditorPane();
		scrollPane.add(editorPane);
		editorPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		editorPane.setEditable(false);
		try {
			editorPane.setPage("http://minecraft-goodtime.github.io/UpdateNotes");//¸üÐÂÈÕÖ¾ÍøÖ·
		} catch (IOException e) {
			e.printStackTrace();
		}


		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel.setBounds(556, 508, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5C0A\u656C\u7684\u6E38\u5BA2");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label.setBounds(623, 508, 138, 15);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("\u8D26\u53F7\u7BA1\u7406");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.main(null);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_1.setBounds(809, 555, 93, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u5148\u767B\u5F55\uFF0C\u6216\u79BB\u7EBF\u6E38\u620F");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(556, 528, 138, 15);
		contentPane.add(lblNewLabel_1);
		
		label_1 = new JLabel("\u5373\u5C06\u5F00\u59CB\u6E38\u620F");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_1.setBounds(556, 548, 205, 15);
		contentPane.add(label_1);
		label_1.setText("¼´½«¿ªÊ¼"+comboBox.getSelectedItem());
		
		JButton btnNewButton_3 = new JButton("\u65B0\u5EFA\u914D\u7F6E");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tip.main(null);
				Tip.dialog.setTitle("ÐÂ½¨ÅäÖÃ");
				Tip.textField.setVisible(true);
				Tip.label.setText("ÇëÊäÈëÐÂµÄÅäÖÃÃû");
			}
		});
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_3.setBounds(130, 570, 110, 23);
		contentPane.add(btnNewButton_3);
		getTime();
	}
	
	public static void getTime()
	{
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		if (hour < 11)
		{
			lblNewLabel.setText("ÔçÉÏºÃ!");
		}
		else if (hour < 13)
		{
			lblNewLabel.setText("ÖÐÎçºÃ£¡");
		}
		else if (hour < 18)
		{
			lblNewLabel.setText("ÏÂÎçºÃ£¡");
		}
		else 
		{
			lblNewLabel.setText("ÍíÉÏºÃ£¡");
		}
	}
}
