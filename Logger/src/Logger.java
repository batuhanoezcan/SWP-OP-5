import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime; 

public class Logger {

	private static Logger log;
	static PrintWriter writer;
	
enum Level{
	error,
	warning,
	info,
	debug
}

Level thelevel;

private Logger() throws IOException
{
	writer = new PrintWriter(new FileWriter("log.txt",true));
}
	
public static Logger getInstance() throws IOException
{
	if(log == null)
	{
		log = new Logger();
	}
	return log;
}

public void log(String information) throws IOException
{
		writer.print(LocalTime.now());
		writer.print(" | ");
		writer.print(information);
		writer.println(" hat sich eingeloggt");	
		writer.flush();
}

public void setFile(String filename) throws IOException
{
	writer = new PrintWriter(new FileWriter(filename,true));
}

public void setLogLvl(String lvl) throws IOException
{
	if(lvl=="error")
	{
		thelevel = Level.error;
	}
	if(lvl=="warning")
	{
		thelevel = Level.warning;
	}
	if(lvl=="info")
	{
		thelevel = Level.info;
	}
	if(lvl=="debug")
	{
		thelevel = Level.debug;
	}
	
}

public void error(String information) throws IOException
{
	writer = new PrintWriter(new FileWriter("error.txt",true));
	writer.print(information);
	writer.flush();
}

public void warning(String information) throws IOException
{
	writer = new PrintWriter(new FileWriter("warning.txt",true));
	if(thelevel == Level.warning || thelevel == Level.info || thelevel == Level.debug)
	{
		writer.print(information);
	}
	writer.flush();
}

public void info(String information) throws IOException
{
	writer = new PrintWriter(new FileWriter("info.txt",true));
	if(thelevel == Level.info || thelevel == Level.debug)
	{
		writer.print(information);
	}	
	writer.flush();
}

public void debug(String information) throws IOException
{
	writer = new PrintWriter(new FileWriter("debug.txt",true));
	if(thelevel == Level.debug)
	{
		writer.print(information);

	}
	writer.flush();
}

}
