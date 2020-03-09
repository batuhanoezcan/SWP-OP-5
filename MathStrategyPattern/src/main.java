
public class main {

	public static void main(String[] args) {
		Context c = new Context(new Divide());
		c.execute(20, 5);
		
		Context a = new Context(new Addition());
		a.execute(3,2);
	}

}
