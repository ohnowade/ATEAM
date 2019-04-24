package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
			Button setUp = new Button("Set Up");
			Button exit = new Button("Exit");
			
			// set up all the buttons
			setButtons(start, setUp, exit);

			// The image for the head of this scene
			Image image = new Image("headMain.png");
			ImageView head = new ImageView(image);
			
			// Add all control elements
			VBox vbox = new VBox();
			vbox.setSpacing(30);
			vbox.setAlignment(Pos.BASELINE_CENTER);
			vbox.getChildren().addAll(head, start, setUp, exit);
			VBox.setMargin(head, new Insets(20, 0, 0, 0));
			vbox.setStyle("-fx-background-color: #000000;");
			BorderPane root = new BorderPane();
			root.setCenter(vbox);
			
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This helps set up the size, font, and background color of all buttons
	 * @param start - the start button
	 * @param setUp - the set up button
	 * @param exit - the exit button
	 */
	private void setButtons(Button start, Button setUp, Button exit) {
		// set the size of all buttons to 200*50
		start.setMinSize(200, 50);
		setUp.setMinSize(200, 50);
		exit.setMinSize(200, 50);
		// set the font of all buttons
		start.setFont(new Font(26));
		setUp.setFont(new Font(26));
		exit.setFont(new Font(26));
		// set background color of all buttons
		start.setStyle("-fx-background-color: #FFA31A;");
		setUp.setStyle("-fx-background-color: #FFA31A;");
		exit.setStyle("-fx-background-color: #FFA31A;");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
