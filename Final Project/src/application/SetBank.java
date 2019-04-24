package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SetBank extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Image image = new Image("setQuestion.jpg");// create image node with my photo
            ImageView title = new ImageView(image);
            title.setFitWidth(500); // set the size of the image title
            title.setPreserveRatio(true);

            Label warning = new Label("Load From File :");  // create required button

            Button confirmB = new Button("Confirm");
            Button addQ = new Button("Add a New Question");
            addQ.setOnMouseClicked(e -> {
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
            Button back = new Button("Back to Menu");
            back.setOnMouseClicked(e -> {
            	Stage mainStage = new Stage();
            	Main main = new Main();
            	main.start(mainStage);
            	mainStage.show();
            	primaryStage.close();
            });

            TextField pathField = new TextField(); // create textfield for file path entering

            HBox CBox = new HBox();   // hbox for file path entering
            CBox.getChildren().addAll(warning, pathField, confirmB);
            CBox.setAlignment(Pos.CENTER);
            CBox.setSpacing(40);


             // Vbox for the two button and the HBox
            VBox centerVBox = new VBox();
            centerVBox.getChildren().addAll(CBox, addQ, back);
            centerVBox.setAlignment(Pos.CENTER);
            VBox.setMargin(CBox, new Insets(20, 0, 70, 0));
            centerVBox.setSpacing(30);



            BorderPane root = new BorderPane();
            root.setTop(title); // set borderPane
            BorderPane.setAlignment(title, Pos.CENTER);
            BorderPane.setMargin(title, new Insets(110, 0, 0, 0));
            BorderPane.setMargin(centerVBox, new Insets(20, 0, 0, 0));

            root.setCenter(centerVBox);


            Scene scene = new Scene(root, 800, 600); // set the scene


            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}

