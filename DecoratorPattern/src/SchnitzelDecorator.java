
public abstract class SchnitzelDecorator implements Schnitzel{

	protected Schnitzel schnitzel;
	
	public SchnitzelDecorator(Schnitzel schnitzel) {
		this.schnitzel = schnitzel;
	}
	
	public void draw() {
		schnitzel.draw();
	}
}
