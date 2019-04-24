package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz extends Application{

	@Override
	public void start(Stage primaryStage) {
		// the label indicating the question
		Label question = new Label("question");
		
		// The image of current question
		Image image = new Image("noImage.jpg");
		ImageView view = new ImageView(image);
		view.setFitWidth(500);
		view.setPreserveRatio(true);
		
		// the choices
		RadioButton first = new RadioButton("first choice");
		RadioButton second = new RadioButton("second choice");
		RadioButton third = new RadioButton("third choice");
		VBox choices = new VBox(first, second, third);
		//choices.setAlignment(Pos.CENTER_LEFT);
		choices.setSpacing(10);
		
		VBox vbox = new VBox(question, view, choices);
		VBox.setMargin(question, new Insets(20, 0, 0, 0));
		VBox.setMargin(choices, new Insets(0, 0, 0, 150));
		vbox.setSpacing(30);
		vbox.setAlignment(Pos.BASELINE_CENTER);

		BorderPane root = new BorderPane();
		root.setCenter(vbox);
		
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
