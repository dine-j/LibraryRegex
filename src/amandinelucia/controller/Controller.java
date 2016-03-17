package amandinelucia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;

import amandinelucia.model.Film;
import amandinelucia.model.Music;
import amandinelucia.view.Library;
import generator.Media;
import generator.MediaGenerator;

public class Controller implements ActionListener {
	
	private static final Pattern filmPattern = Pattern.compile("\\.(flv|gif|mkv|mpeg|mpg|mov)");
	private static final Pattern musicPattern = Pattern.compile("(.+\\s*)(\\s-\\s)(.+\\s*)\\.(aiff|aac|aax|oog|wav|wma)");
	private static final Pattern filmName = Pattern.compile("(?<=^|\\)\\s)([^().]+)");
	private static final Pattern filmYear = Pattern.compile("\\(([^\\s\\)]+)\\)");
	private static final Pattern filmDef = Pattern.compile("HD|SD");
	private static final Pattern theSplit = Pattern.compile("((?<=The\\s).+)");
	private static final Pattern pixelPattern = Pattern.compile("(?<=\\,\\s)([^().p]+)");
	private Library library;
	private List<Media> media;
	private List<Film> films;
	private List<Music> music;
	private Comparator<Film> yearOrder;
	private Comparator<Film> defOrder;
	private Comparator<Music> artistOrder;

	/**
	 * Constructor of the Controller
	 * @param library	Controlled frame
     */
	public Controller(Library library){
		
		this.library = library;
		media = MediaGenerator.getMedia();
		films = new ArrayList<Film>();
		music = new ArrayList<Music>();
		
		yearOrder = new Comparator<Film>(){
			public int compare(Film f1, Film f2){
				return f2.getYear().compareTo(f1.getYear());
			}
		};
		
		defOrder = new Comparator<Film>(){
			public int compare(Film f1, Film f2){
				if(f1.getPixel().length() < f2.getPixel().length()){
					return 1;
				}else if(f1.getPixel().length() > f2.getPixel().length()){
					return -1;
				}else{
				return f2.getPixel().compareTo(f1.getPixel());
				}
			}
		};
		
		artistOrder = new Comparator<Music>(){
			public int compare(Music m1, Music m2){
				return m1.getTempArtist().compareTo(m2.getTempArtist());
			}
		};
		
	}

	/**
	 * Add content to the frame by default (no ordering) and construct the model
	 */
	public void addContent(){  
		for(Media m: media){
			
			Matcher filmMatcher = filmPattern.matcher(m.getName());
			Matcher musicMatcher = musicPattern.matcher(m.getName());

			// Check if the current medium is a film
			if(filmMatcher.find()){
				
				String name ="";
				String year = "";
				String definition = "";
				String tempName = "";
				String pixel = "";
				
				Matcher nameMatcher = filmName.matcher(m.getName());
				Matcher yearMatcher = filmYear.matcher(m.getName());
				Matcher defMatcher = filmDef.matcher(m.getName());
				Matcher pixelMatcher = pixelPattern.matcher(m.getName());
				
				if(nameMatcher.find()){
					name = nameMatcher.group(1);
				}
			
				if(yearMatcher.find()){
					year = yearMatcher.group(1);
				}
			
				if(defMatcher.find()){
					definition = defMatcher.group();
				}
				
				Matcher theMatcher = theSplit.matcher(name);

				if(theMatcher.find()){
					tempName = theMatcher.group(1);
				} else {
					tempName = name;
				}
				
				if(pixelMatcher.find()){
					pixel = pixelMatcher.group(1);
				}

				films.add(new Film(m.getImage(), name, tempName, year, definition, pixel));
				library.addToFilmContents(m.getImage(), year, definition, name);
			
			} else if(musicMatcher.find()){ //Test if the current medium is a music
				String name = musicMatcher.group(1);
				String artist = musicMatcher.group(3);
				String tempName = "";
				String tempArtist = "";

				Matcher theMatcher = theSplit.matcher(name);

				if(theMatcher.find()){
					tempName = theMatcher.group(1);
				} else {
					tempName = name;
				}

				theMatcher = theSplit.matcher(artist);

				if(theMatcher.find()){
					tempArtist = theMatcher.group(1);
				} else {
					tempArtist = artist;
				}

				music.add(new Music(m.getImage(), name, tempName, artist, tempArtist));
				library.addToMusicContents(m.getImage(), name, artist);	
			
			} else {
				library.addToUnclassifiedCont(m.getImage(), m.getName(), "Unclassified");
			}
		}
		library.revalidate();
		library.repaint();
	}

	/**
	 * Action to be performed by the ActionListener
	 * @param e	Event triggering this method (JComboBox)
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// If the change is about films
		if(((JComboBox) e.getSource()).getName().equals("filmComboBox")){
			String s = (String) library.getFilmComboBox().getSelectedItem();
			
			switch(s){
				case "Title": 
					Collections.sort(films);
					updateFilmLibrary();
					break;
					 
				case "Release Year":
					Collections.sort(films, yearOrder);
					updateFilmLibrary();
					break;
					
				case "Quality":
					Collections.sort(films, defOrder);
					//For debugging purposes:
//					System.out.println(films);
					updateFilmLibrary();
					break;
			}
		}
		
		// If the change is about music
		if(((JComboBox) e.getSource()).getName().equals("musicComboBox")){
			String s = (String) library.getMusicComboBox().getSelectedItem();
			
			switch(s){
				case "Track Name":
					Collections.sort(music);
					updateMusicLibrary();
					break;
					
				case "Artist": 
					Collections.sort(music, artistOrder);
					updateMusicLibrary();
			}
		}
		library.revalidate();
		library.repaint();
	}

	/**
	 * Update music panel of the library
	 * First, clear the corresponding panel
	 * Then update the panel with new media
	 */
	private void updateMusicLibrary() {
		library.clearMusicPanel();
		for(Music m: music){
            library.addToMusicContents(m.getImage(), m.getName(), m.getArtist());
        }
	}

	/**
	 * Update film panel of the library
	 * First, clear the corresponding panel
	 * Then update the panel with new media
	 */
	private void updateFilmLibrary() {
		library.clearFilmPanel();
		for(Film f: films){
            library.addToFilmContents(f.getImage(), f.getYear(), f.getDefinition(), f.getName());
        }
	}

}
