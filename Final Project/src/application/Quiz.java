package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Quiz extends Application{

	@Override
	public void start(Stage primaryStage) {
		// the label indicating the question
		Label question = new Label("question");

		// The image of current question
		Image image = new Image("noImage.jpg");
		ImageView view = new ImageView(image);
		view.setFitWidth(700);
		view.setPreserveRatio(true);

		// The label indicating correct answers
		Label answer = new Label("The correct answer is A");
		answer.setVisible(false);

		// the choices
		ArrayList<RadioButton> choices = new ArrayList<RadioButton>();
		RadioButton first = new RadioButton("first choice");
		RadioButton second = new RadioButton("second choice");
		RadioButton third = new RadioButton("third choice");
		// put all choices in a toggle group so that the user could only select one choice
		ToggleGroup group = new ToggleGroup();
		first.setToggleGroup(group);
		second.setToggleGroup(group);
		third.setToggleGroup(group);
		choices.add(first);
		choices.add(second);
		choices.add(third);

		// the button indicating the completion of this question
		Button confirm = new Button("Confirm");
		// Before the user makes selection, it would be disabled
		confirm.setDisable(true);
		// if the user makes any selection, it would be able to be clicked
		for (RadioButton temp : choices) {
			temp.setOnAction(e -> {
				confirm.setDisable(false);
			}); 
		}
		// After the user clicks "confirm", the answer would be checked and shown, the button would lead the
		// user to the next question
			confirm.setOnMouseClicked( e -> {
				if (confirm.getText().equals("Confirm")) {
				confirm.setText("Next");
				answer.setVisible(true);
				} else {
					Stage menuStage = new Stage();
					Quiz quiz = new Quiz();
					quiz.start(menuStage);
					menuStage.show();
					primaryStage.close();
				}
			});

		// set the layout
		HBox hbox = new HBox(answer, confirm);
		HBox.setMargin(confirm, new Insets(0, 0, 0, 700));

		VBox vbox = new VBox(question, view);
		for (int i = 0; i < choices.size(); i++) {
			vbox.getChildren().addAll(choices.get(i));
		}
		
		vbox.getChildren().add(hbox);
		VBox.setMargin(question, new Insets(20, 0, 0, 10));
		VBox.setMargin(view, new Insets(0, 0, 0, 10));
		VBox.setMargin(hbox, new Insets(50, 0, 0, 0));

		vbox.setSpacing(30);
		vbox.setAlignment(Pos.BASELINE_LEFT);

		BorderPane root = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(vbox);
		root.setCenter(scrollPane);

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
