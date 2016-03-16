package amandinelucia.model;

import javax.swing.JLabel;

public class Music implements Comparable<Music>{
	
	private JLabel image;
	private String trackName;
	private String tempName;
	private String artist;
	private String tempArtist;

	/**
	 * Constructor of Music
	 * Create a Music object
	 * @param image	Music's image
	 * @param name	Music's name
	 * @param tempName	Music's temporary name (without 'The' if it is the case)
	 * @param artist	Artist's name
     * @param tempArtist	Artist's temporary name (without 'The' if it is the case)
     */
	public Music(JLabel image, String name, String tempName, String artist, String tempArtist){
		this.image = image;
		this.trackName = name;
		this.tempName = tempName;
		this.artist = artist;
		this.tempArtist = tempArtist;
	}

	/**
	 * Getter of Music's image
	 * @return	A JLabel representation of the image
     */
	public JLabel getImage(){
		return image;
	}

	/**
	 * Getter of Music's name
	 * @return	String representation of the track name
     */
	public String getName(){
		return trackName;
	}

	/**
	 * Getter of Music's artist
	 * @return	String representation of the artist's name
     */
	public String getArtist(){
		return artist;
	}

	/**
	 * Getter of Music's temporary artist
	 * @return String representation of artist's temporary name
     */
	public String getTempArtist(){
		return tempArtist;
	}

	/**
	 * toString representation of Music's object
	 * @return	String representation of Music's object
     */
	public String toString(){
		return trackName + " - " + artist;
	}

	/**
	 * CompareTo method from Comparable interface
	 * Define the default comparison between two Music objects (comparison by name)
	 * @param m	Music Object
	 * @return	Integer representation of the comparison
     */
	@Override
	public int compareTo(Music m) {
		return tempName.compareTo(m.tempName);
	}

}
