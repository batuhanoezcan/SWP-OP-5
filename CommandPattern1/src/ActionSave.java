
public class ActionSave implements ActionListenerCommand{
	
	private Document doc;
	 
    public ActionSave(Document doc) {
        this.doc = doc;
    }
    @Override
    public void execute() {
        doc.save();
    }
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
