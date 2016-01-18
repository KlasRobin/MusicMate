package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HelpDescription {
	
	private Text helpText;
	private Color textColor;

	public HelpDescription(Color color,int xPos, int yPos) {
		textColor = color;
		helpText = new Text(xPos, yPos, "");
		helpText.setVisible(false);
		helpText.setFont(new Font(25));
		helpText.setWrappingWidth(300);
		helpText.setFill(textColor);;
	}
	
	public void showHelpDescription(Pane pane, String helpDescription) {

		ObservableList<Node> objects = pane.getChildren();

		for (Node node : objects) {
			node.setEffect(new BoxBlur(10, 10, 10));
			node.setDisable(true);

		}
		helpText.setEffect(null);
		helpText.setText(helpDescription);
		helpText.setVisible(true);
		pane.setOnMouseClicked(e -> {
			for (Node node : objects) {
				node.setEffect(null);
				node.setDisable(false);
				helpText.setVisible(false);

			}

		});
	}

	public Text getHelpText() {
		return helpText;
	}

	public void setHelpText(Text helpText) {
		this.helpText = helpText;
	}
	
	
	

}
