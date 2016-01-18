package application;

/**
 * Interface for instruments with methods for playback och stopping of playback.
 * 
 * @author Robin_000
 *
 */

/*Just nu �r det h�r interfacet ganska meningsl�st eftersom det endast
 * implementeras av en klass. Vid utveckling av programmet kan man annars 
 * l�tt l�gga till fler instrument (T.ex banjo, ukulele, piano m.m.)
 * som kommer beh�va samma metoder. Vid vidare utveckling av programmet kan fler
 * metoder tillkomma i interfacet.
 */

public interface InstrumentInterface {
	
	/**
	 * Start playback of instrument string.
	 * @param string Number of string to play
	 */
	public void strumString(int string);
	
	/**
	 * Stop playback of instrument string.
	 * @param string Number of string to stop playing
	 */
	public void stopStruming(int string);

}
