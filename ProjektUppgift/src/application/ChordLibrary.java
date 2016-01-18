package application;

import java.io.File;
import java.util.TreeMap;

import javafx.scene.media.AudioClip;
/**Class for storing and playing chords in program ChordLibrary
 * 
 * @author Robin Sjölund
 *
 */

public class ChordLibrary {
	
	private TreeMap<String,AudioClip> chords;

	/**
	 * Class constructor
	 */
	public ChordLibrary() {
	
		chords = new TreeMap<>();
		File catalog = new File("src/Sounds/Chords/");
		addSounds(catalog);
		
		
		
		
	}
	
	/**
	 * Method for playing selected chord sound effect.
	 * 
	 * @param chord Specifies which chord to play
	 */

	public void playChord(String chord){
		System.out.println("Playing: " + chord);
		chords.get(chord).play();
		
	}
	
	private void addSounds(File catalog){
		File[] temp = catalog.listFiles();
		for(File file:temp){
			
			if(file.isDirectory()){
				addSounds(file);
			}
			else{
			File parent = file.getParentFile();
			
			String fileName = file.getName();
			int pos = fileName.lastIndexOf(".");
			if (pos > 0) {
			    fileName = fileName.substring(0, pos);
			}
			String path = parent.getName()+"/"+fileName+".mp3";
			
				chords.put(fileName, new AudioClip(getClass().getResource("/Sounds/Chords/"+path).toString()));
			}
		}
	}
	

		
		
	

}
