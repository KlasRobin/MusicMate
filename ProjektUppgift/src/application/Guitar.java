package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating different kinds of string instruments with different sets
 * of instrumentStrings.
 * 
 * @author Robin_000
 *
 */
public class Guitar implements InstrumentInterface {

	// Aggregering. Varje objekt av Guitar har en list med instanser av
	// InstrumentString, därför blir det agregering.
	private List<InstrumentString> strings;

	/**
	 * Constructor used to create different types of guitars.
	 * 
	 * @param type
	 *            Type of guitar to create, bass or regular guitar.
	 */

	/*
	 * Polymorfism/Overload konstruktor. Eftersom jag har två stycken olika
	 * konstruktorer, med olika inparametrar är det Overload och blir
	 * polymorfism på kompileringsstadiet.
	 */
	public Guitar(InstrumentType type) {

		strings = new ArrayList<>();

		if (type.equals(InstrumentType.GUITAR)) {
			strings.add(new InstrumentString("E1", type));
			strings.add(new InstrumentString("B", type));
			strings.add(new InstrumentString("G", type));
			strings.add(new InstrumentString("D", type));
			strings.add(new InstrumentString("A", type));
			strings.add(new InstrumentString("E2", type));
		} else if (type.equals(InstrumentType.BASS)) {
			strings.add(new InstrumentString("E1", type));
			strings.add(new InstrumentString("A", type));
			strings.add(new InstrumentString("D", type));
			strings.add(new InstrumentString("G", type));
		}

	}

	/**
	 * Constructor used to create guitars with different types of tunings.
	 * 
	 * @param specialTuning
	 *            Type of special tuning
	 */
	public Guitar(SpecialTuning specialTuning) {

		strings = new ArrayList<>();

		strings.add(new InstrumentString("E1", specialTuning));
		strings.add(new InstrumentString("B", specialTuning));
		strings.add(new InstrumentString("G", specialTuning));
		strings.add(new InstrumentString("D", specialTuning));
		strings.add(new InstrumentString("A", specialTuning));
		strings.add(new InstrumentString("E2", specialTuning));

	}

	/**
	 * Start playback of selected InstrumentStrings sound.
	 * 
	 * @param string
	 *            Chooses which string to play.
	 */

	@Override
	public void strumString(int string) {

		strings.get(string).strumString();

	}

	/**
	 * Stop playback of selected InstrumentStrings sound.
	 * 
	 * @param string
	 *            Chooses which string to stop playing.
	 */
	@Override
	public void stopStruming(int string) {

		strings.get(string).stopStrumming();
	}

}
