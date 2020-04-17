
public class Sport implements State {
	
	private String state;
	
	public String getstate()
	{
		return state;
	}
	
	@Override
	public void beschleunigen(int speed) {
		if(speed>180) {
			System.out.println("Das Auto kann im Sportmodus nicht schneller als 180 km/h fahren.");
		}
		else
		{
			System.out.println("Das Auto fährt zurzeit " + speed + " km/h.");
		}
		
	}
	
	@Override
	public String toString() {
		String string = "Das Auto ist im " + state + "modus.";
		return string;
	}

	@Override
	public void setstate() {
		this.state = "Sport";
	}

}
