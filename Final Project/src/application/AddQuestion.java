package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddQuestion extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// The image for the head of this scene
			Image image = new Image("addQuestion.png");
			ImageView head = new ImageView(image);
			head.setPreserveRatio(true);
			head.setFitWidth(300);
			
			// prompt for topic
			Label topic = new Label("Topic: ");
			TextField topicField = new TextField();
			topicField.minWidth(200);
			HBox topicBox = new HBox(topic, topicField);
			
			// prompt for topic
			Label question = new Label("Question: ");
			TextField questionField = new TextField();
			questionField.minWidth(200);
			HBox questionBox = new HBox(question, questionField);
			
			// prompt for topic
			Label imageLabel = new Label("Image Address: ");
			TextField imageField = new TextField();
			imageField.minWidth(200);
			HBox imageBox = new HBox(imageLabel, imageField);
			
			// prompt for topic
			Label correctAnswer = new Label("Correct Answer: ");
			TextField correctField = new TextField();
			correctField.minWidth(200);
			HBox correctBox = new HBox(correctAnswer, correctField);
			
			// prompt for topic
			Label otherAnswers = new Label("Other Answers: ");
			TextField otherField = new TextField();
			otherField.minWidth(200);
			HBox otherBox = new HBox(otherAnswers, otherField);
			
			// two buttons offering choices for the user to go back or to confirm to add
			Button back = new Button("Back");
			Button add = new Button("Add");
			HBox buttons = new HBox(back, add);
			buttons.setSpacing(10);
			buttons.setAlignment(Pos.BOTTOM_RIGHT);
			
			// Add all control elements
			VBox vbox = new VBox();
			vbox.setSpacing(30);
			vbox.setAlignment(Pos.BASELINE_CENTER);
			vbox.getChildren().addAll(head, topicBox, questionBox, imageBox, correctBox, otherBox, buttons);
			VBox.setMargin(head, new Insets(20, 0, 0, 0));
			VBox.setMargin(buttons, new Insets(40, 0, 0, 0));
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