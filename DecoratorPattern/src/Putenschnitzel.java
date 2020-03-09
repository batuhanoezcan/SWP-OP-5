 
public class Putenschnitzel implements Schnitzel {

	@Override
	public void draw() {
		System.out.println("Putenschnitzel");
	}

	@Override
	public double givePrice() {
		return 3.2;
	}

}
