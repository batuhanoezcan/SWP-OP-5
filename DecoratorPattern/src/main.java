
public class main {

	public static void main(String[] args) {

		Schnitzel k = new KetchupDecorator(new Wienerschnitzel());		
		Schnitzel a = new SenfDecorator(k);
		a.draw();
		System.out.println(a.givePrice() + " Euro");
	}

}
