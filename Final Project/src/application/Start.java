package application;

// import java.awt.TextField;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


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


        Button starButton = new Button("Start Quiz");
        Button backButton = new Button("Back to Menu");

        ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2",
                        "Option 3", "Option 4", "Option 5");
        @SuppressWarnings({"rawtypes", "unchecked"})
        ComboBox comboBox = new ComboBox(options);
        setComBox(comboBox);

        TextField numberQ = new TextField();

        HBox centerBox = new HBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(topicLabel, comboBox);

        HBox rightBox = new HBox();
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().addAll(questionLabel, numberQ);

        VBox centerV = new VBox();
        centerV.getChildren().addAll(centerBox, rightBox);
        setCenterVbox(centerV);


        VBox bottomV = new VBox();
        bottomV.getChildren().addAll(starButton, backButton);
        setBottomVbox(bottomV);

        BorderPane root = new BorderPane();
        root.setTop(titleView);
        root.setCenter(centerV);
        root.setBottom(bottomV);

        root.setStyle("-fx-background-color: #000000;");
        BorderPane.setAlignment(centerBox, Pos.TOP_CENTER);
        BorderPane.setAlignment(titleView, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, 800, 600); // set the scene


        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }catch(Exception e) {
        
    }
    }


    public void setBottomVbox(VBox bottomVBox) {
        bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomVBox.setSpacing(80);
        bottomVBox.setPadding(new Insets(20, 70, 70, 70));


    }

    public void setCenterVbox(VBox centerVBox) {
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setSpacing(60);
        centerVBox.setPadding(new Insets(10, 40, 40, 40));
    }



    public void setComBox(@SuppressWarnings("rawtypes") ComboBox comboBox) {
        comboBox.setPromptText("-Select-");
        comboBox.setVisibleRowCount(7);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
