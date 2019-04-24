package application;
	
import java.awt.Paint;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create all buttons
			Button start = new Button("Start");
			start.setOnMouseClicked(e -> {
				Stage startStage = new Stage();
				Start startPage = new Start();
				try {
					startPage.start(startStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				startStage.show();
				primaryStage.close();
			});
			
			Button setUp = new Button("Set Up");
			setUp.setOnMouseClicked(e -> {
      	Stage setStage = new Stage();
      	SetBank setBank = new SetBank();
      	try {
					setBank.start(setStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
      	setStage.show();
      	primaryStage.close();
      });
			
			Button exit = new Button("Exit");

			// The image for the head of this scene
			Image image = new Image("headMain.png");
			ImageView head = new ImageView(image);
			
			// Add all control elements
			VBox vbox = new VBox();
			vbox.setSpacing(30);
			vbox.setAlignment(Pos.BASELINE_CENTER);
			vbox.getChildren().addAll(head, start, setUp, exit);
			VBox.setMargin(head, new Insets(20, 0, 0, 0));
			BorderPane root = new BorderPane();
			root.setCenter(vbox);
			
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Quiz Generator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
