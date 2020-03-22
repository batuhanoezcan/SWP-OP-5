
public class ActionOpen implements ActionListenerCommand{
	
	private Document doc;
	 
    public ActionOpen(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.open();
    }
	@Override
	public void redo() {
		
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
