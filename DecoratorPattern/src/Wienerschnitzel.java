
public class Wienerschnitzel implements Schnitzel {

	@Override
	public void draw() {
		System.out.println("Wienerschnitzel");
	}

	@Override
	public double givePrice() {
		return 3.5;
	}

}
