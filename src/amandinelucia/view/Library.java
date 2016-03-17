package amandinelucia.view;

import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import amandinelucia.controller.Controller;

public class Library extends JFrame {

	private static final String[] filmCBContent = {"Sort", "Title", "Release Year", "Quality"};
	private static final String[] musicCBContent = {"Sort", "Track Name", "Artist"};

	private JPanel filmContents;
	private JPanel musicContents;
	private JPanel unclassifiedCont;
	
	private JComboBox filmComboBox;
	private JComboBox musicComboBox;

	/**
	 * Constructor of Library frame
	 */
	public Library() {

		super("Library");

		setSize(600, 900);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createWidgets();

		setVisible(true);

	}

	/**
	 * Create widgets to be added to the frame
	 */
	private void createWidgets() {

		JPanel filmPanel = createFilmPanel();
		JPanel musicPanel = createMusicPanel();
		JPanel unclassPanel = createUnclassifiedPanel();

		this.add(filmPanel);
		this.add(musicPanel);
		this.add(unclassPanel);
	}

	/**
	 * Create a film panel (first part of the frame)
	 * @return The created film Panel
     */
	private JPanel createFilmPanel() {
		JPanel filmPanel = new JPanel();
		filmPanel.setLayout(new BorderLayout());
		filmPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel filmTitlePanel = new JPanel();
		filmTitlePanel.setLayout(new BorderLayout());
		JLabel films = new JLabel("Films");
		filmTitlePanel.add(films, BorderLayout.WEST);
		filmComboBox = new JComboBox(filmCBContent);
		filmComboBox.setName("filmComboBox");
		filmTitlePanel.add(filmComboBox, BorderLayout.EAST);
		filmPanel.add(filmTitlePanel, BorderLayout.NORTH);

		filmContents = new JPanel();
		filmContents.setLayout(new FlowLayout());
		filmPanel.add(filmContents, BorderLayout.CENTER);
		filmPanel.add(createJScrollPane(filmContents), BorderLayout.CENTER);

		return filmPanel;
	}

	/**
	 * Create a Music panel (second part of the frame)
	 * @return	The created music panel
     */
	private JPanel createMusicPanel() {
		JPanel musicPanel = new JPanel();
		musicPanel.setLayout(new BorderLayout());
		musicPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel musicTitlePanel = new JPanel();
		musicTitlePanel.setLayout(new BorderLayout());
		JLabel music = new JLabel("Music");
		musicTitlePanel.add(music, BorderLayout.WEST);
		musicComboBox = new JComboBox(musicCBContent);
		musicComboBox.setName("musicComboBox");
		musicTitlePanel.add(musicComboBox, BorderLayout.EAST);
		musicPanel.add(musicTitlePanel, BorderLayout.NORTH);

		musicContents = new JPanel();
		musicContents.setLayout(new FlowLayout());
		musicPanel.add(createJScrollPane(musicContents), BorderLayout.CENTER);

		return musicPanel;
	}

	/**
	 * Create panel for unclassified media
	 * @return	The created JPanel
     */
	private JPanel createUnclassifiedPanel() {
		JPanel unclassPanel = new JPanel();
		unclassPanel.setLayout(new BorderLayout());
		unclassPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JLabel unclassified = new JLabel("Unclassified");
		unclassPanel.add(unclassified, BorderLayout.NORTH);

		unclassifiedCont = new JPanel();
		unclassifiedCont.setLayout(new FlowLayout());
		unclassPanel.add(createJScrollPane(unclassifiedCont), BorderLayout.CENTER);

		return unclassPanel;
	}

	/**
	 * Create a JScrollPane
	 * @param panel	The panel where the JScrollPane should be added
	 * @return	The created JScrollPane
     */
	private JScrollPane createJScrollPane(JPanel panel) {
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		return scrollPane;
	}

	/**
	 * Create individual panels for each media
	 * @param image	Image of the media represented by a JLabel
	 * @param name	Name of the media
	 * @param subName	Other description of the media
     * @return	The created individual panel
     */
	private JPanel createIndividualPanel(JLabel image, String name, String subName) {
		JPanel individualPanel = new JPanel();
		individualPanel.setLayout(new BorderLayout());
		image.setHorizontalAlignment(SwingConstants.CENTER);
		individualPanel.add(image, BorderLayout.CENTER);
		
		JPanel description = new JPanel();
		description.setLayout(new GridLayout(2,1));
		JLabel nameLabel = new JLabel("<html><b>" + name + "</b></html>");
		nameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		JLabel subNameLabel = new JLabel(subName);
		subNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		description.add(nameLabel);
		description.add(subNameLabel);
		individualPanel.add(description, BorderLayout.SOUTH);
		
		individualPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		return individualPanel;
	}

	/**
	 * Add a given media to the part for films in the library frame
	 * @param image	JLabel representing the media's image
	 * @param year	Year when th media was produced
	 * @param definition	Media's quality
     * @param name	Media's name
     */
	public void addToFilmContents(JLabel image, String year, String definition, String name) {
		JPanel individualFilmPanel = createIndividualPanel(image, name,year + " - " + definition);
		filmContents.add(individualFilmPanel);
	}

	/**
	 * Add a given media to the part for music in the library frame
	 * @param image	JLabel representing the media's image
	 * @param trackTitle	Media's name
	 * @param singer	This media's singer
     */
	public void addToMusicContents(JLabel image, String trackTitle, String singer) {
		JPanel individualMusicPanel = createIndividualPanel(image, trackTitle, singer);
		musicContents.add(individualMusicPanel);	
	}

	/**
	 * Add a given media to the third part of the library frame (unclassified media)
	 * @param image JLabel representing the media's image
	 * @param name	Media's name
	 * @param unclassified	Any other unclassified information
     */
	public void addToUnclassifiedCont(JLabel image, String name, String unclassified) {
		JPanel individualUnclassPanel = createIndividualPanel(image, name, unclassified);
		unclassifiedCont.add(individualUnclassPanel);	
	}

	/**
	 * Clear the filmPanel of its components
	 */
	public void clearFilmPanel(){
		filmContents.removeAll();
	}

	/**
	 * Clear the musicPanel of its components
	 */
	public void clearMusicPanel(){
		musicContents.removeAll();
	}

	/**
	 * Add an ActionListener to the ComboBoxes
	 * @param controller	ActionListener to be added
     */
	public void addComboBoxListener(Controller controller){
		filmComboBox.addActionListener(controller);
		musicComboBox.addActionListener(controller);
	}

	/**
	 * Getter of the JComboBox for films
	 * @return	The requested JComboBox
     */
	public JComboBox getFilmComboBox(){
		return filmComboBox;
	}

	/**
	 * Getter of the JComboBox for music
	 * @return	The requested JComboBox
     */
	public JComboBox getMusicComboBox(){
		return musicComboBox;
	}

}
