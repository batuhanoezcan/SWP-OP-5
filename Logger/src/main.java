import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		Logger.getInstance().setLogLvl("error");
		Logger.getInstance().debug("123");
		Logger.getInstance().error("1234");
		
	}

	
}
