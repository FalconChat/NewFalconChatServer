package ServerProgram;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;




public class ServerRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsernameField;
	private JPasswordField passwordField;
	public static String OS = System.getProperty("os.name");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerRegister frame = new ServerRegister();
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
	public ServerRegister() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(12, 10, 69, 15);
		contentPane.add(lblNewLabel);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(93, 7, 329, 21);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(12, 46, 69, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //Register
				String un = UsernameField.getText();
				String pw = String.copyValueOf(passwordField.getPassword());
				String fileSeparator = System.getProperty("file.separator");
				MessageDigest digest;
				try {
					digest = MessageDigest.getInstance("SHA-256");
					byte[] hash = digest.digest(pw.getBytes(StandardCharsets.UTF_8));
					pw = Base64.getEncoder().encodeToString(hash);
					JOptionPane.showMessageDialog(rootPane, "User Registered.");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(OS.indexOf("Windows") != -1) //Windows User Input
				{
					File file = new File("C:"+fileSeparator+fileSeparator+"FalconChat"+fileSeparator+"members.txt");
					try 
					{
						FileWriter fw = new FileWriter(file, true);
						fw.write("|"+un+"|"+pw+"|");
						fw.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
				else if(OS.indexOf("Linux") != -1) //Linux User Input
				{
					File file1 = new File("usr"+fileSeparator+"FalconChat"+fileSeparator+"members.txt");
					try 
					{
						FileWriter fw1 = new FileWriter(file1, true);
						fw1.write("^"+un+"^"+pw+"^\n");
						fw1.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(12, 74, 410, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("All passwords are encrypted with SHA-256 method");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 107, 410, 15);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 43, 329, 21);
		contentPane.add(passwordField);
	}
}
