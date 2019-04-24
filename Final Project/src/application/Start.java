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



public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Image image = new Image("start.png");// create image node with my photo
            ImageView titleView = new ImageView(image);
            titleView.setFitWidth(250); // adjust the size of the photo
            titleView.setPreserveRatio(true);

            Label topicLabel = new Label("Topic: ");
            Label questionLabel = new Label("Number of questions: ");


            Button startButton = new Button("Start Quiz");
            startButton.setOnMouseClicked(e -> {
            	Stage quizStage = new Stage();
            	Quiz quiz = new Quiz();
            	quiz.start(quizStage);
            	quizStage.show();
            	primaryStage.close();
            });
            Button backButton = new Button("Back to Menu");
            backButton.setOnMouseClicked(e -> {
            	Stage mainStage = new Stage();
            	Main main = new Main();
            	main.start(mainStage);
            	mainStage.show();
            	primaryStage.close();
            });
            Button selectButton = new Button("Insert");
            ObservableList<String> selected =
                            FXCollections.observableArrayList("-------Selected Topics-------");
            ListView<String> selectedList = new ListView<String>(selected);


            ObservableList<String> options = FXCollections.observableArrayList("Option 1",
                            "Option 2", "Option 3", "Option 4", "Option 5");
            @SuppressWarnings({"rawtypes", "unchecked"})
            ComboBox<String> comboBox = new ComboBox(options);
            setComBox(comboBox, selectButton, selectedList);

            TextField numberQ = new TextField();

            HBox centerBox = new HBox();
            centerBox.setAlignment(Pos.CENTER);
            centerBox.getChildren().addAll(topicLabel, comboBox, selectButton);
            centerBox.setSpacing(20);

            HBox rightBox = new HBox();
            rightBox.setAlignment(Pos.CENTER);
            rightBox.getChildren().addAll(questionLabel, numberQ);

            VBox centerV = new VBox();
            centerV.getChildren().addAll(centerBox, rightBox);
            setCenterVbox(centerV);


            VBox bottomV = new VBox();
            bottomV.getChildren().addAll(startButton, backButton);
            setBottomVbox(bottomV);

            BorderPane root = new BorderPane();
            root.setTop(titleView);

            root.setCenter(centerV);
            root.setBottom(bottomV);
            root.setRight(selectedList);

            root.setStyle("-fx-background-color: #000000;");
            BorderPane.setMargin(titleView, new Insets(50, 0, 0, 0));
            BorderPane.setAlignment(centerBox, Pos.TOP_CENTER);
            BorderPane.setAlignment(titleView, Pos.BOTTOM_CENTER);
            BorderPane.setMargin(selectedList, new Insets(0, 30, 0, 0));
            BorderPane.setMargin(bottomV, new Insets(0,0,60,0));

            Scene scene = new Scene(root, 1200, 800); // set the scene


            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBottomVbox(VBox bottomVBox) {
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomVBox.setSpacing(80);
        bottomVBox.setPadding(new Insets(0, 70, 0, 70));


    }

    public void setCenterVbox(VBox centerVBox) {
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setSpacing(60);
        centerVBox.setPadding(new Insets(10, 0, 40, 40));
    }



    public void setComBox(ComboBox<String> comboBox, Button Insert, ListView<String> selctedL) {
        comboBox.setPromptText("-Select-");
        comboBox.setVisibleRowCount(7);

        Insert.setOnAction((e) -> {
            String temp = comboBox.getSelectionModel().getSelectedItem();
            if (temp != null) {
                selctedL.getItems().add(temp);
            }


        });
        Insert.fire();

    }



    public static void main(String[] args) {
        launch(args);
    }

}
