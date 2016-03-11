package amandinelucia.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Library extends JFrame {
	
	public Library(){
		
		super("Library");
		
		setSize(500, 700);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createWidgets();
		
		setVisible(true);
	
	}

	
	private void createWidgets() {
		
		JPanel filmPanel = new JPanel();
		filmPanel.setLayout(new BorderLayout());
		filmPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel musicPanel = new JPanel();
		musicPanel.setLayout(new BorderLayout());
		musicPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel unclassPanel = new JPanel();
		unclassPanel.setLayout(new BorderLayout());
		unclassPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
		this.add(filmPanel);
		this.add(musicPanel);
		this.add(unclassPanel);
		
		JLabel films = new JLabel("Films");
		filmPanel.add(films, BorderLayout.NORTH);
		JLabel music = new JLabel("Music");
		musicPanel.add(music, BorderLayout.NORTH);
		JLabel unclassified = new JLabel("Unclassified");
		unclassPanel.add(unclassified, BorderLayout.NORTH);
		
		JScrollBar JSB1 = new JScrollBar();
		JSB1.setOrientation(SwingConstants.HORIZONTAL);
		filmPanel.add(JSB1, BorderLayout.SOUTH);
		
		JScrollBar JSB2 = new JScrollBar();
		JSB2.setOrientation(SwingConstants.HORIZONTAL);
		musicPanel.add(JSB2, BorderLayout.SOUTH);

		JScrollBar JSB3 = new JScrollBar();
		JSB3.setOrientation(SwingConstants.HORIZONTAL);
		unclassPanel.add(JSB3, BorderLayout.SOUTH);
		
		JPanel filmContents = new JPanel();
		JPanel musicContents = new JPanel();
		JPanel unclassifiedCont = new JPanel();
		
		filmPanel.add(filmContents, BorderLayout.CENTER);
		musicPanel.add(musicContents, BorderLayout.CENTER);
		unclassPanel.add(unclassifiedCont, BorderLayout.CENTER);	
	}
	
	
	
	@SuppressWarnings("unused")
	private void createMediaPane(String name, JLabel image){
		
		JPanel mediaPane = new JPanel();
		JLabel mediaName = new JLabel(name);
		mediaPane.setLayout(new BorderLayout());
		mediaPane.add(image, BorderLayout.CENTER);
		mediaPane.add(mediaName, BorderLayout.SOUTH);
		
	}

}
