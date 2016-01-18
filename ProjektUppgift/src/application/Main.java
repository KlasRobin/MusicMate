package application;
	

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;



public class Main extends Application {


public static BorderPane root;

@Override
	public void start(Stage primaryStage) {
	
	try {
	
	    URL location = this.getClass().getResource("/view/MenuView.fxml");
		FXMLLoader loader = new FXMLLoader(location);
		root = loader.load();
		
		
		Scene scene = new Scene(root,600,440);
		primaryStage.setResizable(false);
		primaryStage.setTitle("MusicMate 1.0");
		primaryStage.getIcons().add(new Image("/Images/guitar_icon.png"));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}


	public static void main(String[] args) {
		launch(args);
	}
}
