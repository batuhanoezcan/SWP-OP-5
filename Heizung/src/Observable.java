import java.util.ArrayList;

public class Observable {

	private ArrayList<Observerr> observers = new ArrayList<Observerr>();
	int temp = 20;
	
	public void setValue(int value)
	{
		temp = value;
		notifyAllObserver();
	}
	
	public void notifyAllObserver()
	{
		for(Observerr o:observers)
		{
			o.update(temp);
		}
		
	}
	
	public void register(Observerr a)
	{
		observers.add(a);
	}
	
	public void unregister(Observerr a)
	{
		observers.remove(a);
	}
	
	public static void main(String[] args) {
		Observable observable = new Observable();
		Observer1 o1 = new Observer1();
		Observer2 o2 = new Observer2();
		observable.register(o1);
		observable.register(o2);
		observable.setValue(25);
	}
}