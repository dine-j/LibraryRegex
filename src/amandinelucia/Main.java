package amandinelucia;

import amandinelucia.controller.Controller;
import amandinelucia.view.Library;
import generator.MediaGenerator;

public class Main {
	
	public static void main(String[] args){
	
		Library library = new Library();
//		Controller controller = new Controller(library);
		System.out.println(MediaGenerator.getMedia());
	}

}
