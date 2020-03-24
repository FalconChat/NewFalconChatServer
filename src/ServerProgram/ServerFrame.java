package ServerProgram;
import java.awt.EventQueue;
import java.util.Timer; 
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class ServerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PortInput;
	static ServerRegister frame1 = new ServerRegister();	
	public static String OS = System.getProperty("os.name");
	public static int portnumber = 3232; //default port number
	public int backupenable = 0;
	public String absoluteFilePath = null;
	public File folder1 = new File("C:\\");
	public File folder2 = new File("C:\\");
	public String absoluteFilePath2 = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	TimerTask backup_timer = new TimerTask() {
		private FileInputStream inputStream1;
		private FileInputStream inputStream2;
		private FileOutputStream outputStream2;
		private FileOutputStream outputStream1;

		@Override
		public void run()
		{
			try {
				int bytesRead = 0;
				inputStream1 = new FileInputStream(absoluteFilePath);
				inputStream2 = new FileInputStream(absoluteFilePath2); 
				outputStream1 = new FileOutputStream(folder1);
				outputStream2 = new FileOutputStream(folder2);
				byte[] buffer = new byte[1024];   
				byte[] buffer2 = new byte[1024];   
				   try {//members.txt copy
					while ((bytesRead = inputStream1.read(buffer, 0, 1024)) != -1) 
					   {
					    outputStream1.write(buffer, 0, bytesRead);
					   }
					bytesRead = 0;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "Error! members.txt cannot be backup");
				}
				   try {//chatlog.txt copy
						while ((bytesRead = inputStream2.read(buffer2, 0, 1024)) != -1) 
						   {
						    outputStream2.write(buffer2, 0, bytesRead);
						   }
						bytesRead = 0;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(rootPane, "Error! Chatlog.txt cannot be backup");
					}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	public ServerFrame() {
		setTitle("Falcon Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Register");
		lblNewLabel.setBounds(12, 14, 87, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(136, 10, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Group Chat Create");
		lblNewLabel_1.setBounds(12, 47, 110, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.setBounds(136, 43, 97, 23);
		contentPane.add(btnNewButton_1);
		
		List list = new List();
		list.setBounds(239, 47, 185, 135);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Online Members");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(281, 26, 110, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Server Port");
		lblNewLabel_3.setBounds(12, 103, 72, 15);
		contentPane.add(lblNewLabel_3);
		
		PortInput = new JTextField();
		PortInput.setBounds(12, 128, 221, 21);
		contentPane.add(PortInput);
		PortInput.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
				portnumber = Integer.parseInt(PortInput.getText());
				JOptionPane.showMessageDialog(rootPane, "Port Number Saved. Current Port Number: " + Integer.toString(portnumber));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Put number.");
				}
			}
		});
		btnNewButton_2.setBounds(12, 159, 221, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Delete All Uploaded File");
		lblNewLabel_4.setBounds(12, 208, 141, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBounds(213, 204, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Initialize Server(Only once)");
		lblNewLabel_5.setBounds(12, 243, 171, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("Initialize");
		btnNewButton_4.addActionListener(new ActionListener() { //Create File
			public void actionPerformed(ActionEvent e) {
				if(OS == null) //get OS info
				{
					OS = System.getProperty("os.name");
				}
				String fileSeparator = System.getProperty("file.separator");
				if(OS.indexOf("Windows") != -1) //checks whether it is Windows Kind
				{
					absoluteFilePath = "C:"+fileSeparator+fileSeparator+"FalconChat"+fileSeparator+"members.txt";
					absoluteFilePath2 = "C:"+fileSeparator+fileSeparator+"FalconChat"+fileSeparator+"chatlog.txt";
				}
				else if(OS.indexOf("Linux") != -1) //checks whether it is Linux Kind OS
				{
					absoluteFilePath = "usr"+fileSeparator+"FalconChat"+fileSeparator+"members.txt";
					absoluteFilePath2 = "usr"+fileSeparator+"FalconChat"+fileSeparator+"chatlog.txt";
				}
				else //Not Supported OS
				{
					JOptionPane.showMessageDialog(rootPane, "OS Not Supported. FalconChat Supports Linux & Windows. Your OS: "+ OS);
				}
				File file = new File(absoluteFilePath);
				File file2 = new File(absoluteFilePath2);
				try {
					file.createNewFile();
					file2.createNewFile();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(rootPane, "Error, files are not created. Did you create FalconChat?");
				}
				
			}
		});
		btnNewButton_4.setBounds(213, 239, 97, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("Backup all contents");
		lblNewLabel_6.setBounds(12, 277, 171, 15);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("Backup");
		btnNewButton_5.setBounds(213, 273, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JCheckBox uploadcheckbox = new JCheckBox("Allow All Users to upload files(Recommended)");
		uploadcheckbox.setBounds(12, 316, 414, 23);
		contentPane.add(uploadcheckbox);
		
		JCheckBox backupcheck = new JCheckBox("Auto Backup Every 24h(Require Client Restart every 24h) ");
		backupcheck.setBounds(12, 341, 362, 23);
		contentPane.add(backupcheck);
		
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Server On");
		tglbtnNewToggleButton.setBounds(12, 417, 410, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JButton btnNewButton_6 = new JButton("Save Checkbox Changes");
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { //checkbox save
				String fileSeparator = System.getProperty("file.separator");
				Timer timer = new Timer();
				if(uploadcheckbox.isSelected() == true)
				{
					//Not Done
				}
				else
				{
					//Not Done
				}
				if(backupcheck.isSelected() == true)
				{
					if(OS.indexOf("Windows") != -1) //checks whether it is Windows Kind
					{
						absoluteFilePath = "C:"+fileSeparator+fileSeparator+"FalconChat"+fileSeparator+"members.txt";
						absoluteFilePath2 = "C:"+fileSeparator+fileSeparator+"FalconChat"+fileSeparator+"chatlog.txt";
					}
					else if(OS.indexOf("Linux") != -1) //checks whether it is Linux Kind OS
					{
						absoluteFilePath = "usr"+fileSeparator+"FalconChat"+fileSeparator+"members.txt";
						absoluteFilePath2 = "usr"+fileSeparator+"FalconChat"+fileSeparator+"chatlog.txt";
					}
					if(OS.indexOf("Windows") != -1)
					{
						folder1 = new File("C:"+fileSeparator+fileSeparator+"FalconBackup"+fileSeparator+"members.txt");
						folder2 = new File("C:"+fileSeparator+fileSeparator+"FalconBackup"+fileSeparator+"chatlog.txt");
						timer.scheduleAtFixedRate(backup_timer, 1000, 3600000);
					}
					else if(OS.indexOf("Linux") != -1)
					{
						folder1 = new File("usr"+fileSeparator+"FalconBackup"+fileSeparator+"members.txt");
						folder2 = new File("usr"+fileSeparator+"FalconBackup"+fileSeparator+"chatlog.txt");
					}
			}
			}});
		btnNewButton_6.setBounds(12, 383, 412, 23);
		contentPane.add(btnNewButton_6);
	}
}
