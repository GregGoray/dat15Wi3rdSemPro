package view;

import controller.ChooseTherapistController;
import controller.CreateChildProfileController;
import controller.TherapistResumeController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Child;
import model.Therapist;

/**
 * Created by Grzegorz Goraj on 25-05-2016.
 * email: greg.goray@gmail.com
 */
public class ChooseTherapistView extends Application {

    /**
     *  CONTROLLERS
     */

    private ChooseTherapistController controller = new ChooseTherapistController();
    private CreateChildProfileController createChildProfileController = new CreateChildProfileController();

    ///////////////////////////

    /**
     *
     */

    private Stage primaryStage;
    private VBox vBox;
    private Scene scene;


    private Label occupationLbl;

    private Button backBtn;
    private Button submitBtn;
    private Button viewResume;
    private TableView tableView;



    /**
     *  Other Attributes:
     */

    private String currentOccupation = CreateChildProfileView.currentOccupation;
    private TherapistResumeController resumeController = new TherapistResumeController();





    public void startView(String currentOccupation) {


        vBox = new VBox();

        occupationLbl = new Label();
        String textOccupationLbl = "Please select one therapist of category '" + currentOccupation + "':";
        occupationLbl.setText(textOccupationLbl);


        /**
         * Table of Therapists of current Occupation:
         */
        tableView = new TableView();
        TableColumn nameTherapistColumn = new TableColumn("First Name");
        nameTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("name"));

        TableColumn lastNameTherapistColumn = new TableColumn("Last Name");
        lastNameTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("surname"));

        TableColumn telTherapistColumn = new TableColumn("Tel.");
        telTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("mobile"));

        TableColumn occupationColumn = new TableColumn("Occupation");
        occupationColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("occupation"));


        tableView.getColumns().addAll(nameTherapistColumn, lastNameTherapistColumn, occupationColumn, telTherapistColumn);

        //filling up the columns
        ObservableList<Therapist> therapistsList = controller.getTherapistsByProfession();
        tableView.setItems(therapistsList);
        tableView.setMaxHeight(600);


        HBox hBox = new HBox();
        backBtn = new Button("back");

        //Action
        backBtn.setOnAction(event ->  {
            createChildProfileController.startView();
            primaryStage.close();
            // goto createChildProfileVIew
        });

        ////////////////////////////////
        submitBtn = new Button("submit");

        //ACTION
        submitBtn.setOnAction(event ->  {
            try {
                Therapist therapist = (Therapist) tableView.getSelectionModel().getSelectedItem();
                /**
                 * assigning chosen therapist to DB
                 */


            }catch(NullPointerException npe) {
                /**
                 *
                 */
                System.out.println("Exception - fix SubmitBtn");
            }
        });

        viewResume = new Button("Resume");
        viewResume.setOnAction(event -> {

            resumeController.startResumeView();

        });

        hBox.getChildren().addAll(backBtn, viewResume, submitBtn);
        vBox.getChildren().addAll(occupationLbl, tableView, hBox);


        scene = new Scene(vBox, 480, 640);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Available Therapists");
        primaryStage.show();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        startView(currentOccupation);

    }
}
