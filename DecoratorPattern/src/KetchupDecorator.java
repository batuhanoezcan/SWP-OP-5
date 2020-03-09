
public class KetchupDecorator extends SchnitzelDecorator {
	public KetchupDecorator(Schnitzel schnitzel) {
	      super(schnitzel);		
	   }

	   @Override
	   public void draw() {
	      schnitzel.draw();	       
	      setKetchup(schnitzel);
	   }

	   private void setKetchup(Schnitzel schnitzel){
	      System.out.println("Schnitzel hat Ketchup.");
	   }

	@Override
	public double givePrice() {
		return 1.1 + schnitzel.givePrice();
	}
}
