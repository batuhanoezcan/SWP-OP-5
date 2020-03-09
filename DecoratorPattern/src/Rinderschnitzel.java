
public class Rinderschnitzel implements Schnitzel{

	@Override
	public void draw() {
		System.out.println("Rinderschnitzel");
	}

	@Override
	public double givePrice() {
		return 3.4;
	}
	
}
