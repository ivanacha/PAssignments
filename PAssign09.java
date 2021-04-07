package progAssignment;
/*
 * File: PAssign09.java
 * @author Ivan Acha
 * Course: CSCI1302
 * Created on: April 4, 2021
 * Modified: April 7, 2021
* Description: Displays the layout of a microwave oven using the KeypadCustomPane and displays the digits of the numbers clicked. 
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PAssign09 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			// Creates two panes for both parts of the Microwave and a keyboard pane.
			BorderPane pane = new BorderPane();
			BorderPane pane2 = new BorderPane();
			KeyPadCustomPane keyPad = new KeyPadCustomPane();

			// Setting the panes in the right position.
			pane.setPadding(new Insets(5, 5, 5, 5));
			keyPad.setPadding(new Insets(110, 5, 25, 0));
			
			
			
			// Creating the microwave layout
			Image image = new Image("file:image/microwave2.jpeg");
			Image image2 = new Image("file:image/microwave buttons.jpeg");
			ImageView imageView1 = new ImageView(image);
			ImageView imageView2 = new ImageView(image2);
			
			// Setting the images in the appropriate panes.
			imageView1.setFitWidth(image.getWidth());
			imageView1.setFitHeight(image.getHeight());
			pane.setCenter(imageView1);
			
			imageView2.setFitWidth(image2.getWidth());
			imageView2.setFitHeight(image2.getHeight());
			
			pane2.getChildren().addAll(imageView2, keyPad);
			pane.setRight(pane2);
			
			TextField txt = keyPad.getTxtField();
			
			pane2.setTop(txt);
			
			// Create a scene and place it in the stage and place the scene in it.
			Scene scene = new Scene(pane);
			primaryStage.setTitle("PAssign09"); 
			primaryStage.setScene(scene); 
			primaryStage.show(); 
			primaryStage.setResizable(false);
			System.out.println("App");
			System.out.println("Working directory: " + System.getProperty("user.dir"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}

}
