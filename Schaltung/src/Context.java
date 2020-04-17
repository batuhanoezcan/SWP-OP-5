
public class Context implements State{

	private State car;
	
	@Override
	public void beschleunigen(int speed) {
		if(car == null) {
			System.out.println("Das Auto ist im Neutral-Zustand.");
		}
		else
		{
			car.beschleunigen(speed);
		}
	}
	
	@Override
	public void setstate() {
		car.setstate();
	}

	public void setCarstate(State state) {
		this.car = state;
	}

	
	
	public State getCarstate()
	{
		return car;
	}
	
	public String toString() {
		return car.toString();
	}
	
}
