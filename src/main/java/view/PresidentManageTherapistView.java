package view;

import controller.PresidentManageTherapistController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Grzegorz Goraj on 21-05-2016.
 * email: greg.goray@gmail.com
 */
public class PresidentManageTherapistView {

    private Stage primaryStage;
    private Scene scene;

    private BorderPane borderPane;

    private Button loginBtn;
    private TableView.TableViewSelectionModel tableView;

   /* @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = getScene();

        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    public Scene getScene() {

        /**
         * 3 main Buttons
         */


        /**
         * Side elements : LoginLbl & Login
         */

        loginBtn = new Button("Log Out");

        /**
         * BorderPane family
         */
        borderPane = new BorderPane();


        scene = new Scene(borderPane, 1200, 640);
        return scene;
    }
}
