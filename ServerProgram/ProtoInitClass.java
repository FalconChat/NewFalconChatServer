package ServerProgram;
public class ProtoInitClass 
{
	static ProtoLoginFrame plf;
	static ProtoFrame pf;
	public static void main(String[] args)
	{
		
		plf = new ProtoLoginFrame();
		plf.setVisible(true);
		pf= new ProtoFrame();
		pf.setVisible(false);
	}
}

