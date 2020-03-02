
public class Wiedersehen implements IState {

	@Override
	public void goNext(Context context) {

		if(context.isValid()) {
			context.setState(new Bestellen());
			printMsg();

			}
			else {
				context.setState(new BestellungGeben());
				printMsg();

			}
	}

	@Override
	public void printMsg() {
		System.out.println("Auf Widersehen!");
	}

	
}
