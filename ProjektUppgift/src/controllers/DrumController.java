package controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.DrumKit;
import application.HelpDescription;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class DrumController implements Initializable {

	private HelpDescription help;
	
	@FXML
	private CheckBox hotkeyEnabler;
	@FXML
	private Button helpButton;
	@FXML
	private Text c, v, b, d, f, g, h, j, k, l, m;
	private List<Text> hotkeys;
	@FXML
	private Circle kick1, kick2, hiHat, snare, crash, crash2, ride, tom1, tom2, tom3;
	@FXML
	Polygon cowbell;

	@FXML
	private AnchorPane pane;
	private DrumKit drumKit;
	final private String HELP_DESCRIPTION = "To play a drum, simply click on it or press its hotkey. Hotkeys can be enabled/disabled with checkbox.";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		hotkeys = Arrays.asList(c, v, b, d, f, g, h, j, k, l, m);
		help = new HelpDescription(Color.BLACK, 170, 150);
		pane.getChildren().add(help.getHelpText());

		helpButton.setOnAction(e -> {
			help.showHelpDescription(pane, HELP_DESCRIPTION);
		});

		hotkeyEnabler.setOnAction(e -> {
			boolean selected = hotkeyEnabler.isSelected();
			if (selected) {
				for (Text hotkey : hotkeys) {
					hotkey.setVisible(true);
				}
			} else {
				for (Text hotkey : hotkeys) {
					hotkey.setVisible(false);
				}
			}

		});

		drumKit = new DrumKit();
		Color cymbals = new Color(1, 0.671, 0.118, 1.0);
		kick1.setId("35");
		kick2.setId("36");
		hiHat.setId("44");
		snare.setId("40");
		crash.setId("49");
		crash2.setId("57");
		ride.setId("51");
		tom1.setId("50");
		tom2.setId("47");
		tom3.setId("43");
		cowbell.setId("56");

		Circle[] drums = { kick1, kick2, hiHat, snare, crash, crash2, ride, tom1, tom2, tom3 };

		for (Circle drum : drums) {
			addClickProperty(drum);
		}
		addClickProperty(cowbell);

		Main.root.setOnKeyPressed(e -> {

			switch (e.getCode()) {
			case V:
				drumKit.play(kick2.getId());
				kick2.setFill(Color.BLUE);
				break;
			case C:
				drumKit.play(kick1.getId());
				kick1.setFill(Color.BLUE);
				break;
			case B:
				drumKit.play(snare.getId());
				snare.setFill(Color.BLUE);
				break;
			case H:
				drumKit.play(hiHat.getId());
				hiHat.setFill(Color.BLUE);
				break;
			case J:
				drumKit.play(ride.getId());
				ride.setFill(Color.BLUE);
				break;
			case K:
				drumKit.play(crash.getId());
				crash.setFill(Color.BLUE);
				break;
			case L:
				drumKit.play(crash2.getId());
				crash2.setFill(Color.BLUE);
				break;
			case D:
				drumKit.play(tom1.getId());
				tom1.setFill(Color.BLUE);
				break;
			case F:
				drumKit.play(tom2.getId());
				tom2.setFill(Color.BLUE);
				break;
			case G:
				drumKit.play(tom3.getId());
				tom3.setFill(Color.BLUE);
				break;
			case M:
				drumKit.play(cowbell.getId());
				cowbell.setFill(Color.BLUE);
				break;
			default:
				break;

			}
		});

		Main.root.setOnKeyReleased(e -> {

			switch (e.getCode()) {
			case V:
				kick2.setFill(Color.WHITE);
				break;
			case C:
				kick1.setFill(Color.WHITE);
				break;
			case B:
				snare.setFill(Color.WHITE);
				break;
			case H:
				hiHat.setFill(cymbals);
				break;
			case J:
				ride.setFill(cymbals);
				break;
			case K:
				crash.setFill(cymbals);
				break;
			case L:
				crash2.setFill(cymbals);
				break;
			case D:
				tom1.setFill(Color.WHITE);
				break;
			case F:
				tom2.setFill(Color.WHITE);
				break;
			case G:
				tom3.setFill(Color.WHITE);
				break;
			case M:
				cowbell.setFill(Color.DODGERBLUE);
			default:
				break;
			}

		});

	}

	private <T extends Shape> void addClickProperty(T drum) {

		drum.setOnMouseClicked(e -> {
			drumKit.play(drum.getId());
		});

	}

}
