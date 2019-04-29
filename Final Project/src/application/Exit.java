package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class represents the Exit page of the application
 */
public class Exit extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// The label prompting the user and the field where the user types
		Label namefile = new Label("File Name: ");
		TextField file = new TextField();

		// three buttons required
		// This button saves the quiz to local as a file and prompts a confirm window, after which
		// the user would exit the application
		Button save = new Button("Save");
		save.setOnMouseClicked(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Are you sure to save?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				primaryStage.close();
			}
		});
		// this button exits the application after prompting a confirm window
		Button notsave = new Button("Don't Save");
		notsave.setOnMouseClicked(e ->{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText("Are you sure to leave without saving ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				primaryStage.close();
			}
		});
		// this button leads the user back to the starting menu
		Button back = new Button("Back to Menu");
		back.setOnMouseClicked(e -> {
			Stage mainStage = new Stage();
			Main main = new Main();
			main.start(mainStage);
			mainStage.show();
			primaryStage.close();
		});

		// Add and organize all control elements
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.BASELINE_CENTER);
		hbox.setSpacing(30);
		hbox.getChildren().addAll(namefile, file, save);
		VBox vbox = new VBox();
		vbox.setSpacing(30);
		vbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.getChildren().addAll(hbox, notsave, back);
		VBox.setMargin(hbox, new Insets(200, 0, 0, 0));

		BorderPane root = new BorderPane();
		root.setCenter(vbox);
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Exit");
		primaryStage.show();
	}
}
