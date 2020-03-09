
public class Factory {

	public IPizza getPizza(String type) {	
		 if(type.equalsIgnoreCase("Tonno")){
			  return new Tonno();    
		      } 
		 else if(type.equalsIgnoreCase("Margherita")){
		      return new Margherita();		    
		      }
		 else if(type.equalsIgnoreCase("Dönerpizza")){
		         return new Dönerpizza();
		      }
		 else {
			 return null;
		 }
	}
}
