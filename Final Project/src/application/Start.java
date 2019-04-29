package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents the starting page before the first question appears
 */
public class Start extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// the image for the head of this scene
			Image image = new Image("headStart.png");
			ImageView titleView = new ImageView(image);
			// adjust the size 
			titleView.setFitWidth(250); 
			titleView.setPreserveRatio(true);

			// Create all labels required
			Label topicLabel = new Label("Topic: ");
			Label questionLabel = new Label("Number of questions: ");
			Label selectLabel = new Label("-------Selected Topics-------");

			// create all buttons needed
			// This button represents the start of a new quiz
			Button startButton = new Button("Start Quiz");
			// the button leads the user to the first question of the new quiz
			startButton.setOnMouseClicked(e -> {
				Stage quizStage = new Stage();
				Quiz quiz = new Quiz();
				quiz.start(quizStage);
				quizStage.show();
				primaryStage.close();
			});

			// This button leads the user back to the starting menu
			Button backButton = new Button("Back to Menu");
			backButton.setOnMouseClicked(e -> {
				Stage mainStage = new Stage();
				Main main = new Main();
				main.start(mainStage);
				mainStage.show();
				primaryStage.close();
			});

			// This button helps the user to select topics of the quiz
			Button selectButton = new Button("Select");

			// the listView demonstrating topics selected
			ObservableList<String> selected =
					FXCollections.observableArrayList();
			ListView<String> selectedList = new ListView<String>(selected);

			// the combo box containing all present topics that could be selected by the user
			ObservableList<String> options = FXCollections.observableArrayList("Option 1",
					"Option 2", "Option 3", "Option 4", "Option 5");
			@SuppressWarnings({"rawtypes", "unchecked"})
			ComboBox<String> comboBox = new ComboBox(options);
			setComBox(comboBox, selectButton, selectedList);

			// the button used to delete selected topics from the list view
			Button delete = new Button("Delete");
			delete.setOnMouseClicked(e -> {
				if (!selectedList.getSelectionModel().isEmpty()) {
					int index = selectedList.getSelectionModel().getSelectedIndex();
					String topic = selectedList.getItems().remove(index);
					comboBox.getItems().add(topic);
					comboBox.getItems().sort(String.CASE_INSENSITIVE_ORDER);
				}
			});

			// the text field for the user to enter the number of questions in the quiz
			TextField numberQ = new TextField();

			// Organize all control elements and add functions to them
			HBox topicBox = new HBox();
			topicBox.setAlignment(Pos.CENTER);
			topicBox.getChildren().addAll(topicLabel, comboBox, selectButton);
			topicBox.setSpacing(20);
			HBox.setMargin(selectButton, new Insets(0, 0, 0, 20));

			HBox queNumBox = new HBox();
			queNumBox.setAlignment(Pos.CENTER);
			queNumBox.getChildren().addAll(questionLabel, numberQ);
			HBox.setMargin(numberQ, new Insets(0, 0, 0, 35));

			VBox centerV = new VBox();
			centerV.getChildren().addAll(topicBox, queNumBox);
			setCenterVbox(centerV);

			VBox rightV = new VBox(selectLabel, selectedList, delete);
			rightV.setSpacing(30);
			VBox.setMargin(selectLabel, new Insets(73, 0, 0, 0));

			VBox bottomV = new VBox();
			bottomV.getChildren().addAll(startButton, backButton);
			setBottomVbox(bottomV);

			BorderPane root = new BorderPane();
			root.setTop(titleView);

			root.setCenter(centerV);
			root.setBottom(bottomV);
			root.setRight(rightV);

			root.setStyle("-fx-background-color: #000000;");
			BorderPane.setMargin(titleView, new Insets(50, 0, 0, 0));
			BorderPane.setAlignment(topicBox, Pos.TOP_CENTER);
			BorderPane.setAlignment(titleView, Pos.BOTTOM_CENTER);
			BorderPane.setMargin(rightV, new Insets(0, 30, 0, 0));
			BorderPane.setMargin(bottomV, new Insets(0,0,60,0));

			Scene scene = new Scene(root, 1200, 800); // set the scene

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Start");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This helps set the structure of bottom vertical box
	 * @param bottomVBox
	 */
	private void setBottomVbox(VBox bottomVBox) {
		bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
		bottomVBox.setSpacing(80);
		bottomVBox.setPadding(new Insets(0, 70, 0, 70));
	}

	/**
	 * This helps set the structure of central vertical box
	 * @param centerVBox
	 */
	private void setCenterVbox(VBox centerVBox) {
		centerVBox.setAlignment(Pos.CENTER);
		centerVBox.setSpacing(60);
		centerVBox.setPadding(new Insets(10, 0, 40, 40));
	}

	/**
	 * This helps set up the function of topic selections
	 * @param comboBox
	 * @param Insert
	 * @param selctedL
	 */
	private void setComBox(ComboBox<String> comboBox, Button Insert, ListView<String> selectedL) {
		comboBox.setPromptText("-Select-");
		comboBox.setVisibleRowCount(7);
		comboBox.setMinWidth(150);

		// the button would insert the selected topic into the list
		Insert.setOnMouseClicked((e) -> {
			String temp = comboBox.getSelectionModel().getSelectedItem();
			if (temp != null) {
				selectedL.getItems().add(temp);
				comboBox.getItems().remove(temp);
			}
		});
	}
}
