package ServerProgram;
public class ProtoInitClass {
	static ProtoLoginFrame pf;
	public static void main(String[] args)
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				pf = new ProtoLoginFrame();
				pf.setVisible(true);
			}
		});
	}
}
