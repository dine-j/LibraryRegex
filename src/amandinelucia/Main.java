package amandinelucia;

import amandinelucia.controller.Controller;
import amandinelucia.view.Library;

public class Main {
	
	public static void main(String[] args){
	
		Library library = new Library();
		Controller controller = new Controller(library);
		library.addComboBoxListener(controller);
		controller.addContent();
		
		
	}

}
