package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Guitar;
import application.HelpDescription;
import application.InstrumentType;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BassTunerController implements Initializable {

	private Guitar bassGuitar;

	private HelpDescription help;

	@FXML
	private Line E1, D, A, G;
	@FXML
	private Button helpButton;
	@FXML
	private StackPane pane;
	final private String HELP_DESCRIPTION = "To play a string, simply hover over it with your mousepointer!";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		help = new HelpDescription(Color.WHITE, 310, 100);
		pane.getChildren().add(help.getHelpText());

		bassGuitar = new Guitar(InstrumentType.BASS);

		addHoverProperty(E1, 0);
		addHoverProperty(A, 1);
		addHoverProperty(D, 2);
		addHoverProperty(G, 3);

		helpButton.setOnAction(e -> {
			help.showHelpDescription(pane, HELP_DESCRIPTION);
		});

	}

	private void addHoverProperty(Line bassString, int bassStringNumber) {

		final InvalidationListener hoverListener = new InvalidationListener() {

			public void invalidated(Observable ov) {

				if (bassString.isHover()) {

					bassGuitar.strumString(bassStringNumber);
					bassString.setStroke(Color.RED);
					bassString.setEffect(new Glow(80));
				}

				else {
					bassGuitar.stopStruming(bassStringNumber);
					bassString.setStroke(Color.TRANSPARENT);
				}

			}

		};

		bassString.hoverProperty().addListener(hoverListener);

	}

}
