
public class GeldVerlangen implements IState {

	@Override
	public void goNext(Context context) {

		if(context.isValid()) {
			context.setState(new Kochen());
			printMsg();

			}
			else {
				context.setState(new Bestellen());
				printMsg();

			}
		
	}

	@Override
	public void printMsg() {
		System.out.println("4 Euro bitte!");
	}

	
}
