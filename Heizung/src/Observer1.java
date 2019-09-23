public class Observer1 implements Observerr{

	@Override
	public void update(int temp) {
		System.out.println("Die Temperatur ist zurzeit " + temp +" Grad Celsius.");	
		
	}
}
