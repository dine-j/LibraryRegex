package amandinelucia.model;

import javax.swing.JLabel;

public class Film implements Comparable<Film>{
	
	private JLabel image;
	private String name;
	private String year;
	private String definition;
	private String tempName;
	private String pixel;

	/**
	 * Constructor of Film object
	 * @param image Film's image
	 * @param name	Film's name
	 * @param tempName	Film's temporary name
	 * @param year	Film's year
	 * @param def	Film's quality
     * @param pixel	Film's definition in pixels
     */
	public Film(JLabel image, String name, String tempName, String year, String def, String pixel){
		this.image = image;
		this.name = name;
		this.tempName = tempName;
		this.year = year;
		this.definition = def;
		this.pixel = pixel;
	}

	/**
	 * Getter of Film's image
	 * @return	A JLabel representation of the image
	 */
	public JLabel getImage(){
		return image;
	}

	/**
	 * Getter of Film's name
	 * @return	String representation of the Film's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Getter of Film's year
	 * @return	String representation of the Film's year
     */
	public String getYear(){
		return year;
	}

	/**
	 * Getter of Film's quality
	 * @return	String representation of Film's quality: HD or SD
     */
	public String getDefinition(){
		return definition;
	}

	/**
	 * Getter of Film's definition in pixels
	 * @return	String representation of Film's pixels: 480, 720, 1080p
     */
	public String getPixel(){
		return pixel;
	}

	/**
	 * toString representation of the Film's object
	 * @return	String representation of the Film's object
     */
	public String toString(){
		return name + " " + year + " " + definition;
	}

	/**
	 * CompareTo method from Comparable interface
	 * Define the default comparison between two Film objects (comparison by name)
	 * @param f	Film Object
	 * @return	Integer representation of the comparison
	 */
	@Override
	public int compareTo(Film f) {
		return tempName.compareTo(f.tempName);
	}
	
	

}
