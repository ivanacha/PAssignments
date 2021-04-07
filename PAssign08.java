package progAssignment;
/*
 * File: PAssign08.java
 * @author Ivan Acha
 * Course: CSCI1302
 * Created on: March 28, 2021
 * Modified: March 31, 2021
 * Description: Displays the layout of a microwave oven using the KeypadPane. 
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PAssign08 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
public void start(Stage primaryStage) {
		
		try {
			// Creates two panes for both parts of the Microwave and a keyboard pane.
			BorderPane pane = new BorderPane();
			StackPane pane2 = new StackPane();
			KeyPadPane keyPane = new KeyPadPane(true);


			// Setting the panes in the right position.
			pane.setPadding(new Insets(5, 5, 5, 5));
			keyPane.setPadding(new Insets(110, 5, 25, 0));
			
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
			
			pane2.getChildren().addAll(imageView2, keyPane);
			pane.setRight(pane2);
			

			
			
			// Create a scene and place it in the stage and place the scene in it.
			Scene scene = new Scene(pane);
			primaryStage.setTitle("PAssign08 (Microwave)"); 
			primaryStage.setScene(scene); 
			primaryStage.show(); 
			primaryStage.setResizable(false);
			System.out.println("App");
			System.out.println("Working directory: " + System.getProperty("user.dir"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

}
