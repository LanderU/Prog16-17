import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author Lander
 * 
 */
public class AppendObject extends ObjectOutputStream{

	//Constructor
		public AppendObject(OutputStream out) throws IOException
		{	super(out);	}
	
	protected void writeStreamHeader(){
		
	}

}// class
