
public class SenfDecorator extends SchnitzelDecorator {
	public SenfDecorator(Schnitzel schnitzel) {
	      super(schnitzel);		
	   }

	   @Override
	   public void draw() {
	      schnitzel.draw();	       
	      setSenf(schnitzel);
	   }

	   private void setSenf(Schnitzel schnitzel){
	      System.out.println("Schnitzel hat Senf.");
	   }

	@Override
	public double givePrice() {
		return 0.9 + schnitzel.givePrice();
	}
}
