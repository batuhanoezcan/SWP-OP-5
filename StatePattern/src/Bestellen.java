
public class Bestellen implements IState {

	@Override
	public void goNext(Context context) {
		if(context.isValid()) {
		context.setState(new GeldVerlangen());
		printMsg();

		}
		else {
			context.setState(new Bestellen());
			printMsg();

		}
	}
		
	@Override
	public void printMsg() {
		System.out.println("Bestellung bitte!");
	}

	
}
