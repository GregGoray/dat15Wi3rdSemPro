package view;

import controller.AssociateTherapistChildController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Therapist;

/**
 * Created by Grzegorz Goraj on 22-05-2016.
 * email: greg.goray@gmail.com
 */
public class AssociateTherapistChild extends Application {

    /**
     *  Controllers:
     */
    private AssociateTherapistChildController associateCtrl = new AssociateTherapistChildController();

    /**
     * FX stuff:
     */
    private BorderPane borderPane;
    private TableView therapistTable;
    private TableView childTable;




    public Scene startAssociateTherapistChild() {

        /**
         *  Horisontal cONTAINER
         */

        HBox centerHbox = new HBox();



        /**
         *         therapist table
         */
        therapistTable = new TableView();

        TableColumn nameTherapistColumn = new TableColumn("First Name");
        nameTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("name"));

        TableColumn lastNameTherapistColumn = new TableColumn("Last Name");
        lastNameTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("surname"));

        TableColumn telTherapistColumn = new TableColumn("Tel.");
        telTherapistColumn.setCellValueFactory(new PropertyValueFactory<Therapist, String>("mobile1"));

        therapistTable.getColumns().addAll(nameTherapistColumn, lastNameTherapistColumn, telTherapistColumn);

        //filling up the columns
        ObservableList<Therapist> therapistsList = FXCollections.observableList(associateCtrl.setTherapistToTable());
        therapistTable.setItems(therapistsList);
        therapistTable.setMaxHeight(600);

        /**
         *          child table
         */
        childTable = new TableView();
        TableColumn nameChildColumn = new TableColumn("First Name");
        TableColumn lastNameChildColumn = new TableColumn("Last Name");
        TableColumn telParentsColumn = new TableColumn("Parents Tel.");
        childTable.getColumns().addAll(nameChildColumn, lastNameChildColumn, telParentsColumn);
        childTable.setMaxHeight(600);

        centerHbox.setSpacing(80);
        centerHbox.setAlignment(Pos.CENTER);
        centerHbox.getChildren().addAll(therapistTable, childTable);


        /**
         * Border Pane - adding VBoxes to new Parent
         */
        borderPane = new BorderPane();
        borderPane.setCenter(centerHbox);

        /**
         *  Scene
         */

        Scene scene = new Scene(borderPane, 1200, 640);
        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = startAssociateTherapistChild();
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
