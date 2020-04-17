
public class main {

	public static void main(String[] args) {
		Context car = new Context();
		
		car.beschleunigen(50);
		
		car.setCarstate(new Standard());
		car.setstate();
		System.out.println(car);
		
		car.beschleunigen(80);
		car.beschleunigen(120);
		
		car.setCarstate(new Sport());
		car.setstate();
		System.out.println(car);

		car.beschleunigen(120);
		car.beschleunigen(190);
	}

}
