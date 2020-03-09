import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Factory factory = new Factory();

		Scanner s = new Scanner(System.in);
	
		String pizza = s.nextLine();
		IPizza a = factory.getPizza(pizza);
		System.out.println(a.toString());
		
		s.close();
	}

}
