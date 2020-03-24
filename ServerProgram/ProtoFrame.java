package ServerProgram;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProtoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtoFrame frame = new ProtoFrame();
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
	public ProtoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane tPMyCurrentIP = new JTextPane();
		tPMyCurrentIP.setBounds(14, 103, 139, 19);
		contentPane.add(tPMyCurrentIP);
		
		JTextPane tPOpenedPort = new JTextPane();
		tPOpenedPort.setBounds(14, 156, 139, 19);
		contentPane.add(tPOpenedPort);
		
		JTextPane tPServerLogExceptions = new JTextPane();
		tPServerLogExceptions.setBounds(11, 336, 171, 200);
		contentPane.add(tPServerLogExceptions);
		
		JList lstOnlineUsers = new JList();
		lstOnlineUsers.setBounds(200, 304, 185, -200);
		contentPane.add(lstOnlineUsers);
		
		JList lstOfflineUsers = new JList();
		lstOfflineUsers.setBounds(200, 336, 188, 200);
		contentPane.add(lstOfflineUsers);
		
		JButton btnManageUsers = new JButton("");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

			}
		});
		btnManageUsers.setBounds(14, 189, 170, 25);
		contentPane.add(btnManageUsers);
		
		JButton btnAutoSetup = new JButton("");
		btnAutoSetup.setBounds(14, 229, 170, 25);
		contentPane.add(btnAutoSetup);
		
		JButton btnServerStatus = new JButton("");
		btnServerStatus.setBounds(14, 278, 170, 25);
		contentPane.add(btnServerStatus);
		
		JButton btnServerOnOff = new JButton("");
		btnServerOnOff.setBounds(13, 546, 374, 25);
		contentPane.add(btnServerOnOff);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 392, 600);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\robot\\eclipse-workspace\\FalconChatServer-master\\images\\bgimage.png"));
		contentPane.add(lblNewLabel);
		//make btns transparent
		btnManageUsers.setOpaque(false);
		btnManageUsers.setContentAreaFilled(false);
		btnManageUsers.setBorderPainted(false);
		
		btnAutoSetup.setOpaque(false);
		btnAutoSetup.setContentAreaFilled(false);
		btnAutoSetup.setBorderPainted(false);
		
		btnServerStatus.setOpaque(false);
		btnServerStatus.setContentAreaFilled(false);
		btnServerStatus.setBorderPainted(false);
		
		btnServerOnOff.setOpaque(false);
		btnServerOnOff.setContentAreaFilled(false);
		btnServerOnOff.setBorderPainted(false);
	}
}
