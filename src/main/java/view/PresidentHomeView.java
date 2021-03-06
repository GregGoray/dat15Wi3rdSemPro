package view;

import controller.CreateChildProfileController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Grzegorz Goraj on 20-05-2016.
 * email: greg.goray@gmail.com
 */
public class PresidentHomeView extends Application{

    private CreateChildProfileController createChildProfileController = new CreateChildProfileController();

    private Stage primaryStage;
    private Scene scene;

    private BorderPane borderPane;
    private FlowPane flowPane;

    private Button childBtn;
    private Button parentBtn;
    private Button therapistBtn;
    private Button loginBtn;




    public Scene getPresidentView() {

        /**
         * 3 main Buttons
         */

        childBtn = new Button("Child");
        childBtn.setPrefSize(80, 80);
        childBtn.setOnAction(event -> {

            createChildProfileController.startView();
            primaryStage.hide();

        });


        parentBtn = new Button("Parent");
        parentBtn.setPrefSize(80, 80);
        parentBtn.setOnAction(event -> {


        });


        therapistBtn = new Button("Therapist");
        therapistBtn.setPrefSize(80, 80);
        therapistBtn.setOnAction(event -> {


        });



        /**
         * Side elements : LoginLbl & Login
         */

        loginBtn = new Button("Log Out");

        /**
         * BorderPane family
         */

        borderPane = new BorderPane();
        borderPane.setTop(loginBtn);

        flowPane = new FlowPane();
        flowPane.getChildren().addAll(childBtn, parentBtn, therapistBtn);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setPadding(new Insets(10, 10, 10,10));
        flowPane.setVgap(4);
        flowPane.setHgap(40);

        flowPane.setPrefWrapLength(210);
        borderPane.setCenter(flowPane);


        scene = new Scene(borderPane, 1200, 840);
        return scene;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setScene(getPresidentView());
        primaryStage.show();
    }
}
