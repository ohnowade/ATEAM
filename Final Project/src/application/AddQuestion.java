package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 

/**
 * This class represents the page in which the user can add a new question
 *
 */
public class AddQuestion extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// The image for the head of this scene
			Image image = new Image("headAddQuestion.png");
			ImageView head = new ImageView(image);
			head.setPreserveRatio(true);
			head.setFitWidth(300);

			// prompt for topic
			Label topic = new Label("Topic: ");
			TextField topicField = new TextField();
			topicField.setPrefWidth(200);
			HBox topicBox = new HBox(topic, topicField);

			// prompt for question
			Label question = new Label("Question: ");
			TextArea questionField = new TextArea();
			questionField.setPrefWidth(400);
			questionField.setPrefHeight(70);
			HBox questionBox = new HBox(question, questionField);

			// prompt for the address of image
			Label imageLabel = new Label("Image Address: ");
			TextField imageField = new TextField();
			imageField.setPrefWidth(200);
			HBox imageBox = new HBox(imageLabel, imageField);

			// prompt for correct answer of the question to be added
			Label correctAnswer = new Label("Correct Answer: ");
			TextField correctField = new TextField();
			correctField.setPrefWidth(200);
			HBox correctBox = new HBox(correctAnswer, correctField);

			// prompt for other choices
			Label otherChoices = new Label("Other Choices: ");
			TextField otherField = new TextField();
			Button addChoices = new Button("Add Choices");
			otherField.setPrefWidth(200);
			HBox otherBox = new HBox(otherChoices, otherField, addChoices);
			HBox.setMargin(addChoices, new Insets(0, 0, 0, 215));

			// two buttons offering choices for the user to go back or to confirm to add
			Button back = new Button("Back");
			// the "Back" button leads the user back to the Set Up page
			back.setOnMouseClicked(e -> {
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
			// the "Add" button would complete the addition of current new question and lead
			// the user to the addition of next new question
			Button add = new Button("Add");
			HBox buttons = new HBox(back, add);
			buttons.setSpacing(10);
			buttons.setAlignment(Pos.BOTTOM_RIGHT);
			add.setOnMouseClicked(e -> {
				Stage addStage = new Stage();
				AddQuestion addPage = new AddQuestion();
				try {
					addPage.start(addStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				addStage.show();
				primaryStage.close();
			});

			// Add all control elements
			VBox vbox = new VBox();
			vbox.setSpacing(30);
			vbox.setAlignment(Pos.BASELINE_CENTER);
			vbox.getChildren().addAll(head, topicBox, questionBox, imageBox, correctBox, otherBox, buttons);
			VBox.setMargin(head, new Insets(20, 0, 0, 0));
			VBox.setMargin(buttons, new Insets(40, 0, 0, 0));

			// If user chooses to add more choices
			addChoices.setOnMouseClicked(
					e -> {
						TextField extraChoice = new TextField();
						extraChoice.setPrefWidth(200);
						HBox newChoice = new HBox(extraChoice);
						HBox.setMargin(extraChoice, new Insets(0, 0, 0, otherChoices.getWidth()));
						vbox.getChildren().add(vbox.getChildren().size() - 1, newChoice);
					});

			BorderPane root = new BorderPane();
			ScrollPane scrollpane = new ScrollPane(vbox);
			root.setCenter(scrollpane);

			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("Add a New Question");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}