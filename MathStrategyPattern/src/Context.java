
public class Context {
	private IStrategy s;
	
	public Context(IStrategy s) {
		this.s=s;
	}
	
	public void execute(double n1,double n2) {
		System.out.println(s.calculate(n1, n2));
	}
}
