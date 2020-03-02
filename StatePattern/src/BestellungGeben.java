
public class BestellungGeben implements IState {

	@Override
	public void goNext(Context context) {

		if(context.isValid()) {
			context.setState(new Wiedersehen());
			printMsg();

			}
			else {
				context.setState(new Kochen());
				printMsg();

			}
	}

	@Override
	public void printMsg() {
		System.out.println("Bitteschön!");
	}

	
}
