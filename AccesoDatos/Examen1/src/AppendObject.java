import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendObject extends ObjectOutputStream{

	public AppendObject(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	protected void writeStreamHeader(){
		
	}
}//class
