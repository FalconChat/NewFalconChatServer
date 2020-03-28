package ServerProgram;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class ProtoLoginFrame extends JFrame {
public static String ID = "Admin";
public static String PW = "6c569aabbf7775ef8fc570e228c16b98";
public static String INPUTID = "";
public static String INPUTPW = ""; 
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtoLoginFrame frame = new ProtoLoginFrame();
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
	public ProtoLoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProtoInitClass.pf.setVisible(true);
				ProtoInitClass.plf.setVisible(false);
			}
		});
		btnTest.setBounds(106, 401, 97, 25);
		contentPane.add(btnTest);
		
		tfID = new JTextField();
		tfID.setBounds(25, 158, 261, 25);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(25, 252, 261, 25);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				INPUTID = tfID.getText(); 
				INPUTPW = tfPassword.getText(); 
				try {
		            MessageDigest md = MessageDigest.getInstance("MD5");
		            md.update(INPUTPW.getBytes());
		            byte[] bytes = md.digest();
		            StringBuilder sb = new StringBuilder();
		            for(int i=0; i< bytes.length ;i++)
		            {
		                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		            }
		            INPUTPW = sb.toString();
		        } 
		        catch (NoSuchAlgorithmException e) 
		        {
		            e.printStackTrace();
		        }
				if(ID.equals(INPUTID) && PW.equals(INPUTPW))
				{
					ProtoInitClass.pf.setVisible(true);
					ProtoInitClass.plf.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ID or Password is incorrect.","Error",JOptionPane.WARNING_MESSAGE);
				}
				
		}});
		btnLogin.setBounds(96, 357, 120, 31);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 289, 496);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\robot\\eclipse-workspace\\FalconChatServer-master\\images\\ServerLogin.png"));
		contentPane.add(lblNewLabel);
		
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
	}
}
