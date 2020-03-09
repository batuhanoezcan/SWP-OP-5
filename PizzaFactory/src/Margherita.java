
public class Margherita implements IPizza{

	private static String[] ingredients= {"Tomaten","Käse","Teig"};
	
	@Override
	public String getPizza() {
		return "Margherita";
	}

	@Override
	public String[] getIngredients() {
		return ingredients;
	}
	
	@Override
	public String toString() {
		String ing="";
		for(int i = 0; i<ingredients.length; i++) {
			ing = ing + ingredients[i] + ", ";
		}
		return ing;
	}
}
