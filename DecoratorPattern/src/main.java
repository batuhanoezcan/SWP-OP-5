
public class main {

	public static void main(String[] args) {

		Schnitzel k = new KetchupDecorator(new Wienerschnitzel());
		k.draw();
		System.out.println(k.givePrice() + " Euro");
		
		Schnitzel a = new SenfDecorator(new Rinderschnitzel());
		a.draw();
		System.out.println(a.givePrice() + " Euro");
	}

}
