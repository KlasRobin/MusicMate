package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.ChordLibrary;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;

public class GuitarChordController implements Initializable {

	@FXML
	ImageView A, A7, Am, Am7, A6, A9, Asharp, Asharpm, Asharpm7, Abchord, Adim, Asharpmaj7,
	          B,B7,Bm,Bm7,B4,B7sharp9,B11,Bmaj,Bmmaj7,Bmsus9,Bm7b5,Bm6, 
	          C,C11,C7,C9,Cadd9,Cm,Cm7,Cmaj7,Csharp,Csharp7,Csharpm,Csharpmaj,
	          D,D4,D7,D9,Dm,Dm7,Dmaj7,Dsharp,Dsharp7,Dsharpm,Dsharpm7,Dsus2,
	          E,E6,E7,E7b9,E7sharp9,E9,Ebadd9,Em,Em6,Em7,Emaj7,Esus,
	          F,F11,F6,F7,F9,Fm,Fm6,Fm7,Fmaj7,Fmmaj7,Fsharp,Fsharpm,
	          G,G11,G4Chord,G7,G7sharp9,G9,Gadd9,Gm,Gm6,Gm7,Gmaj7,Gmaj9;
	private ColorAdjust selected;
    private ChordLibrary chordLibrary;
	
    
    
    //Override är ett exempel på runtime polymorfism. Metoden overridas från interfacet.
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	chordLibrary = new ChordLibrary();
    	selected = new ColorAdjust(-0.7, 0.7, 0.1, 0.7);
		ArrayList<ImageView> chordList = new ArrayList<>();
		chordList.addAll(Arrays.asList(A, A7, Am, Am7, A6, A9, Asharp, Asharpm, Asharpm7, Abchord, Adim, Asharpmaj7,
										B,B7,Bm,Bm7,B4,B7sharp9,B11,Bmaj,Bmmaj7,Bmsus9,Bm7b5,Bm6,
										C,C11,C7,C9,Cadd9,Cm,Cm7,Cmaj7,Csharp,Csharp7,Csharpm,Csharpmaj,
										E,E6,E7,E7b9,E7sharp9,E9,Ebadd9,Em,Em6,Em7,Emaj7,Esus,
										D,D4,D7,D9,Dm,Dm7,Dmaj7,Dsharp,Dsharp7,Dsharpm,Dsharpm7,Dsus2,
								        F,F11,F6,F7,F9,Fm,Fm6,Fm7,Fmaj7,Fmmaj7,Fsharp,Fsharpm,
								        G,G11,G4Chord,G7,G7sharp9,G9,Gadd9,Gm,Gm6,Gm7,Gmaj7,Gmaj9));

		
		

		for (ImageView chord : chordList) {
			addHoverProperty(chord);
		}
		
		for (ImageView chord : chordList) {
			chord.setOnMouseClicked(e->{
			playChord(chord);	
			});
		}
		
		

	}

	private void addHoverProperty(ImageView chord) {
		final InvalidationListener hoverListener = new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (chord.isHover()) {
					chord.setEffect(selected);
				} else {
					chord.setEffect(null);
				}

			}

		};
		
		chord.hoverProperty().addListener(hoverListener);

	}
	
	private void playChord(ImageView chord){
		chordLibrary.playChord(chord.getId());
	}

}