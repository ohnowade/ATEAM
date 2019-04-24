package application;



import java.awt.image.TileObserver;
import java.util.Collection;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title = new Label("Start");
        
         setTitle(title);
        Label topicLabel = new Label("Topic: ");
        Label questionLabel = new Label("Number of questions: ");
        setLable(topicLabel, questionLabel);
       
        Button starButton = new Button("Start Quiz");
        Button backButton = new Button("Back to Menu");
        SetButton(starButton, backButton);

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
        root.setTop(title);
        root.setCenter(centerV);
        root.setBottom(bottomV);
        
        root.setStyle("-fx-background-color: #000000;");
        BorderPane.setAlignment(centerBox, Pos.TOP_CENTER);
        BorderPane.setAlignment(title, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, 800, 600); // set the scene


        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
 public void SetButton(Button starButton, Button backButton) {
     starButton.setMinSize(200, 50);
     backButton.setMinSize(200, 50);
     starButton.setFont(new Font(26));
     backButton.setFont(new Font(26));
     starButton.setStyle("-fx-background-color: #FFA31A;");
     backButton.setStyle("-fx-background-color: #FFA31A;");
 }
 public void setBottomVbox(VBox bottomVBox) {
     bottomVBox.setAlignment(Pos.BOTTOM_CENTER);
     bottomVBox.setSpacing(80);
     bottomVBox.setPadding(new Insets(20, 70, 70, 70));

     
 }
 public void setCenterVbox(VBox centerVBox) {
     centerVBox.setAlignment(Pos.CENTER);
     centerVBox.setSpacing(40);
     centerVBox.setPadding(new Insets(10, 40, 40, 40));
 }
 
 public void setTitle(Label title) {
      
     title.setFont(new Font(100));
     title.setTextFill(Color.WHITE);
 }
 public void setLable(Label qLabel, Label nLabel) {
     qLabel.setFont(new Font(35));
     qLabel.setTextFill(Color.WHITE);
     nLabel.setFont(new Font(35));
     nLabel.setTextFill(Color.WHITE);;
 }
 
 public void setComBox(ComboBox<String> comboBox) {
     comboBox.setPromptText("-Select-");
     comboBox.setVisibleRowCount(3);

 }
 
    public static void main(String[] args) {
        launch(args);
    }

}
