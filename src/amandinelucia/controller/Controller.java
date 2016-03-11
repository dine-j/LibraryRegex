package amandinelucia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import amandinelucia.view.Library;
import generator.Media;
import generator.MediaGenerator;

public class Controller implements ActionListener {
	
	private Library library;
	private MediaGenerator MG;
	private ArrayList<Media> media;
	
	private static Pattern filmPattern = Pattern.compile("((\\w)+(\\s)*)+\\.(flv|gif|mkv|mpeg|mpg|mov)");
	
	public Controller(Library library){
		
		this.library = library;
		media = MediaGenerator.getMedia();
	}

	
	public void addContent(){
		for(Media m: media){
			
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
