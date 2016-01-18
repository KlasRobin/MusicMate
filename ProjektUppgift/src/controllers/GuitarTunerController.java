package controllers;

import java.net.URL;

import java.util.ResourceBundle;

import application.Guitar;
import application.HelpDescription;
import application.InstrumentType;
import application.SpecialTuning;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GuitarTunerController implements Initializable {
	
	@FXML
	private Rectangle smallE, B, G, D, A, bigE;
	@FXML
	private StackPane pane;
	@FXML
	private Button helpButton;

	@FXML
	private Text currentTuningText, stringsText;
	private Guitar standardE, standardD, dropD, openG;
	private Guitar currentTuning;
	private HelpDescription help;
	final private String HELP_DESCRIPTION = "To change tuning, right-click anywhere. To play a string, hover over it with your mousepointer!";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		help = new HelpDescription(Color.WHITE, 310, 100);
		pane.getChildren().add(help.getHelpText());
		helpButton.setOnAction(e -> {
			help.showHelpDescription(pane, HELP_DESCRIPTION);
		});
		currentTuning = new Guitar(InstrumentType.GUITAR);
		standardE = new Guitar(SpecialTuning.STANDARD_E);
		standardD = new Guitar(SpecialTuning.STANDARD_D);
		dropD = new Guitar(SpecialTuning.DROP_D);
		openG = new Guitar(SpecialTuning.OPEN_G);

		addHoverProperty(smallE, 5);
		addHoverProperty(B, 1);
		addHoverProperty(G, 2);
		addHoverProperty(D, 3);
		addHoverProperty(A, 4);
		addHoverProperty(bigE, 0);

		ContextMenu contextMenu = createContextMenu();
		ObservableList<MenuItem> menuList = contextMenu.getItems();
		pane.setOnContextMenuRequested(e -> {
			contextMenu.show(pane, e.getScreenX(), e.getScreenY());

		});

		menuList.get(0).setOnAction(e -> {
			setTuning(standardE);
			currentTuningText.setText("Standard E");
			stringsText.setText("   E A D G B E");
		});
		menuList.get(1).setOnAction(e -> {
			setTuning(dropD);
			currentTuningText.setText("Drop D");
			stringsText.setText("   D A D G B E");
		});
		menuList.get(2).setOnAction(e -> {
			setTuning(standardD);
			currentTuningText.setText("Standard D");
			stringsText.setText("   D G C F A D");
		});
		menuList.get(3).setOnAction(e -> {
			setTuning(openG);
			currentTuningText.setText("Open G");
			stringsText.setText("   D G D G B D");
		});

	}

	private void addHoverProperty(Rectangle guitarString, int guitarStringNumber) {

		final InvalidationListener hoverListener = new InvalidationListener() {

			public void invalidated(Observable ov) {

				if (guitarString.isHover()) {

					currentTuning.strumString(guitarStringNumber);
					guitarString.setFill(Color.YELLOW);
					guitarString.setEffect(new Glow(50));
				}

				else {
					currentTuning.stopStruming(guitarStringNumber);
					guitarString.setFill(Color.TRANSPARENT);
				}

			}

		};

		guitarString.hoverProperty().addListener(hoverListener);

	}

	private ContextMenu createContextMenu() {
		ContextMenu contextMenu = new ContextMenu();
		RadioMenuItem standardRi = new RadioMenuItem("Standard E");
		RadioMenuItem dropDRi = new RadioMenuItem("Drop D");
		RadioMenuItem standardDRi = new RadioMenuItem("Standard D");
		RadioMenuItem openGRi = new RadioMenuItem("Open G");

		ToggleGroup tg = new ToggleGroup();
		standardRi.setSelected(true);
		standardRi.setToggleGroup(tg);
		dropDRi.setToggleGroup(tg);
		standardDRi.setToggleGroup(tg);
		openGRi.setToggleGroup(tg);

		contextMenu.getItems().addAll(standardRi, dropDRi, standardDRi, openGRi);

		return contextMenu;

	}

	private void setTuning(Guitar tuning) {

		currentTuning = tuning;

	}

}
