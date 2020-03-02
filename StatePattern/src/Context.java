
public class Context {

	private boolean valid;
	private IState state = new Bestellen();
	
	public void advance() {
		setValid(true);
		state.goNext(this);
	}
	
	public void beginning() {
		setValid(false);
		setState(new Bestellen());
		state.printMsg();
	}
	
	public void cancel() {
		setValid(false);
		state.goNext(this);
	}
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public IState getState() {
		return state;
	}
	public void setState(IState state) {
		this.state = state;
	}
	
}
