package application;

import javafx.scene.media.AudioClip;

/**
 * Class used to create instrumentStrings and play sound of them.
 * @author Robin_000
 *
 */

public class InstrumentString  {
	
	private final AudioClip STRING_SOUND;
	private String name;
	
	/**
	 * 
	 * Construtctor to create strings for either a guitar or a bassguitar
	 * @param note Chooses which stringsound to load
	 * @param type Type of instrument
	 */
	public InstrumentString(String note, InstrumentType type){
		
		String path = null;
		
		switch (type) {
		case GUITAR:
			path = "/Sounds/Tuner/Gitarr/Standard/";
			break;
		case BASS:
			path = "/Sounds/Tuner/Bas/";
			break;

		}
		
		
		name = note;
		STRING_SOUND = new AudioClip(getClass().getResource(path+note+".wav").toString());
		STRING_SOUND.setCycleCount(AudioClip.INDEFINITE);
	}
	
	
	/**
	 * Constructor to create string based on special tuning type.
	 * 
	 * @param note Chooses which stringsound to load
	 * @param tuning Chooses which tuning to load stringsound from
	 */
	public InstrumentString(String note, SpecialTuning tuning){
		String path=null;
		
		switch (tuning) {
		case STANDARD_D:
			path = "/Sounds/Tuner/Gitarr/D/";
			break;
		case DROP_D:
			path = "/Sounds/Tuner/Gitarr/DropD/";
			break;
		case OPEN_G:
			path = "/Sounds/Tuner/Gitarr/OpenG/";
			break;
		
		case STANDARD_E:
			path = "/Sounds/Tuner/Gitarr/Standard/"; 
			break;
			
		case STANDARD_BASS:
			break;
		
			}
		name = note;
		STRING_SOUND = new AudioClip(getClass().getResource(path+note+".wav").toString());
		STRING_SOUND.setCycleCount(AudioClip.INDEFINITE);
	}
	
	
	/**
	 *Start playback of string sound.
	 */
	public void strumString(){
		
		STRING_SOUND.play();
		System.out.println(name+" string is playing");
	}
	
	
	/**
	 * Stop playback of string sound.
	 */
	public void stopStrumming(){
	
	   STRING_SOUND.stop();	
	}

	
}
