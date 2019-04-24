package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Result extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// The image for the head of this scene
		Image image = new Image("result.png");
		ImageView head = new ImageView(image);
		head.setFitWidth(700);
		head.setPreserveRatio(true);
		
		//Set the Score to show
		VBox score = getLabelScore(0,0,0);
		
		//Set the button
		Button back = new Button("Back to menu");
		Button again = new Button ("Try new quiz");
		
		//Set the pane
		VBox result = new VBox (head, score, back, again);
		VBox.setMargin(result, new Insets(50, 0, 0, 0));
		result.setSpacing(30);
		result.setAlignment(Pos.TOP_CENTER);
		BorderPane root = new BorderPane();
		root.setCenter(result);
		
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz");
		primaryStage.show();
		
	}
	
	private VBox getLabelScore(int num_correct, int num_answer, int percentage) {
		
		Label score = new Label("Final quiz score: ");
		Label num_cor = new Label("#correct: " + num_correct);
		Label num_ans = new Label("#answer: " + num_answer);
		Label percent = new Label("Percentage: " + percentage);
		VBox result = new VBox (score,num_cor, num_ans, percent);
		result.setAlignment(Pos.CENTER);
		result.setSpacing(10);
		return result;
	}
	public static void main(String[] args) {
		launch(args);
	}

}