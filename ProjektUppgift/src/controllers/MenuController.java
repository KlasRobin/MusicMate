package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;


public class MenuController implements Initializable {
    
	@FXML 
	private MenuItem guitarButton, bassButton;
	@FXML 
	private Button chordLibraryButton, drumkitButton, quitButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Pane pane = null;
		TabPane tabPane = null;
		
		
		guitarButton.setOnAction(e->{
			loadView("TunerView",pane);
		});
		bassButton.setOnAction(e->{
			loadView("BassTunerView",pane);
		});
		chordLibraryButton.setOnAction(e->{
			loadView("GuitarChordView",tabPane);
		});
		drumkitButton.setOnAction(e->{
			loadView("DrumView",pane);
		});
		quitButton.setOnAction(e->{
			Platform.exit();
		});
		
	}
	
	private <T extends Parent> void loadView(String scene, T pane){
		URL location = this.getClass().getResource("/view/"+scene+".fxml");
		
		try {
			pane = FXMLLoader.load(location);
			Main.root.setCenter(pane);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}

