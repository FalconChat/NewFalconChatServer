package ServerProgram;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class ProtoRegister extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtoRegister frame = new ProtoRegister();
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
	public ProtoRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfID = new JTextField();
		tfID.setBounds(66, 143, 130, 22);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(66, 171, 130, 22);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(66, 200, 130, 22);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBounds(23, 104, 130, 25);
		contentPane.add(btnDelete);
		
		JButton btnManage = new JButton("");
		btnManage.setBounds(23, 63, 130, 25);
		contentPane.add(btnManage);
		
		JButton btnRegister = new JButton("");
		btnRegister.setBounds(23, 22, 130, 25);
		contentPane.add(btnRegister);
		
		JList list = new JList();
		list.setBounds(241, 22, 154, 271);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 396, 300);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\robot\\eclipse-workspace\\FalconChatServer-master\\images\\falconchatregister.png"));
		contentPane.add(lblNewLabel);
		
		btnRegister.setOpaque(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		
		btnDelete.setOpaque(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		
		btnManage.setOpaque(false);
		btnManage.setContentAreaFilled(false);
		btnManage.setBorderPainted(false);
		
		
	}
}
