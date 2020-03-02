
public class Kochen implements IState {

	@Override
	public void goNext(Context context) {

		if(context.isValid()) {
			context.setState(new BestellungGeben());
			printMsg();

			}
			else {
				context.setState(new GeldVerlangen());
				printMsg();

			}
	}

	@Override
	public void printMsg() {
		System.out.println("Bitte warten!");
	}

	
}
