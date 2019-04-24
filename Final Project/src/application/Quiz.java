package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
		
		// the button indicating the completion of this question
		Button confirm = new Button("Confirm");
		
		// the choices
		RadioButton first = new RadioButton("first choice");
		RadioButton second = new RadioButton("second choice");
		RadioButton third = new RadioButton("third choice");
		ToggleGroup group = new ToggleGroup();
		first.setToggleGroup(group);
		second.setToggleGroup(group);
		third.setToggleGroup(group);
		
		VBox vbox = new VBox(question, view, first, second, third, confirm);
		VBox.setMargin(question, new Insets(20, 0, 0, 10));
		VBox.setMargin(view, new Insets(0, 0, 0, 10));
		VBox.setMargin(confirm, new Insets(100, 0, 0, 900));

		vbox.setSpacing(30);
		vbox.setAlignment(Pos.BASELINE_LEFT);

		BorderPane root = new BorderPane();
		root.setCenter(vbox);
		
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
