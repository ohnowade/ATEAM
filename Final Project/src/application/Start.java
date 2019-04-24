package application;


import java.util.Collection;
// import java.awt.TextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title = new Label("Start");
        Label topicLabel = new Label("Topic: ");
        Label questionLabel = new Label("Number of questions: ");
        Button starButton = new Button("Start Quiz");
        Button backButton = new Button("Back to Menu");

        ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2",
                        "Option 3", "Option 4", "Option 5");
        @SuppressWarnings({"rawtypes", "unchecked"})
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("-Select-");
        comboBox.setVisibleRowCount(3);

        TextField numberQ = new TextField();

        BorderPane root = new BorderPane();
        VBox centerVBox = new VBox();
        centerVBox.setSpacing(50);
        HBox centerBox = new HBox();
        centerBox.setAlignment(Pos.CENTER);

        centerBox.getChildren().addAll(topicLabel, comboBox);

        HBox rightBox = new HBox();
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().addAll(questionLabel, numberQ);
        centerVBox.getChildren().addAll(centerBox, rightBox);

        VBox bottomVbox = new VBox();
        bottomVbox.setAlignment(Pos.CENTER_LEFT);
        bottomVbox.setSpacing(150);
        
        bottomVbox.getChildren().addAll(starButton, backButton);



        root.setTop(title);
        root.setCenter(centerVBox);
        root.setRight(bottomVbox);
        

        Scene scene = new Scene(root, 1200, 800); // set the scene


        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jiayu's First JavaFX program"); // set the titile of the scene
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
