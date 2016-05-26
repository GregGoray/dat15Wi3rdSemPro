package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Grzegorz Goraj on 25-05-2016.
 * email: greg.goray@gmail.com
 */
public class TestVIew extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label1 = new Label("Search");
        Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
        label1.setGraphic(new ImageView(image));
        label1.setTextFill(Color.web("#0076a3"));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(label1);


        Scene scene = new Scene(borderPane, 400,400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
