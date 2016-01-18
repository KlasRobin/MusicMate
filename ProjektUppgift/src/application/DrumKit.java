package application;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 * Class used to play drum sounds from midi library.
 * 
 * @author Robin_000
 *
 */

/*
 * Vet att det dyker upp en varning i konsollen. För att fixa det behöver trixa
 * i registret. Varningen påverkar inte funktionaliteten. Se:
 * http://stackoverflow.com/questions/16428098/groovy-shell-warning-could-not-
 * open-create-prefs-root-node
 */

public class DrumKit {

	private Synthesizer synth;
	private MidiChannel[] channels;

	public DrumKit() {
		try {
			synth = MidiSystem.getSynthesizer();

			synth.open();

		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		channels = synth.getChannels();

	}

	/**
	 * Plays drum sound directly from midi library
	 * 
	 * @param noteNumber MIDI note number
	 */
	public void play(String noteNumber) {

		int midiNote = Integer.parseInt(noteNumber);

		channels[9].noteOn(midiNote, 80);

	}

}
