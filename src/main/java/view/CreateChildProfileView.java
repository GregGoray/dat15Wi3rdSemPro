package view;

import controller.AssociateTherapistChildController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Grzegorz Goraj on 22-05-2016.
 * email: greg.goray@gmail.com
 */
public class CreateChildProfileView {

    /**
     *  Controllers:
     */
    private AssociateTherapistChildController associateCtrl = new AssociateTherapistChildController();


    /**
     * FX stuff:
     */
    private BorderPane borderPane;

    private Label disabilitiesLbl;
    private Label availableTherapists;


    private Label oligoPicLbl;
    private Label hipoPicLbl;
    private Label logoPicLbl;
    private Label waterPicLbl;
    private Label physioPicLbl;

    private Button oligoPicBtn;
    private Button hipoPicBtn;
    private Button logoPicBtn;
    private Button waterPicBtn;
    private Button physioPicBtn;

    private Button logOutBtn;
    private Button homeBtn;
    private Button profilePictureBtn;
    private Button nextBtn;

    private TextArea disabilitiesTxtArea;

    private TextField nameField;
    private TextField surnameField;
    private TextField streetNumberField;
    private TextField postCodeField;
    private TextField cityField;


    /**
     * Other Attributes:
     *
     */

    // STATIC:

    public static String currentOccupation = "oligo";



    /**
     * Method used to create CreateChildProfileView
     * @return
     */
    public Scene startAssociateTherapistChild() {

        /**
         *  Main Container - border Pane
         */

        borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,20,10,20));


        /**
         * LEFT
         */

        VBox vBoxLeft = new VBox();


        /**
         *  Childern - top to bottom
         */



        HBox hBox2 = new HBox();


        profilePictureBtn = new Button("Picture");
        profilePictureBtn.setId("profilePictureBtn");
        profilePictureBtn.setPrefSize(110, 150);

        hBox2.setPrefWidth(500);
        hBox2.getChildren().add(profilePictureBtn);


        ///////////////////////////////

        HBox hBox3 = new HBox();

        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setPrefWidth(180);

        surnameField = new TextField();
        surnameField.setPromptText("Surname");
        surnameField.setPrefWidth(180);

        hBox3.setSpacing(40);
        hBox3.setPadding(new Insets(30, 0, 0, 0));
        hBox3.setPrefWidth(500);
        hBox3.getChildren().addAll(nameField, surnameField);

        ///////////////////////////////

        HBox hBox4 = new HBox();

        streetNumberField = new TextField();
        streetNumberField.setPromptText("Street and house number");
        streetNumberField.setPrefWidth(400);
        hBox4.setPrefWidth(500);
        hBox4.getChildren().add(streetNumberField);

        ///////////////////////////////

        HBox hBox5 = new HBox();

        postCodeField = new TextField();
        postCodeField.setPromptText("Post Code");

        cityField = new TextField();
        cityField.setPromptText("City");
        hBox5.setSpacing(72);
        hBox5.setPrefWidth(500);
        hBox5.getChildren().addAll(postCodeField, cityField);

        //////////////////////////////



        HBox hBox6 = new HBox();
        availableTherapists = new Label();
        availableTherapists.setText("Available Therapists");
        availableTherapists.setId("availableTherapistLbl");
        availableTherapists.setAlignment(Pos.CENTER);

        hBox6.setPadding(new Insets(30, 0, 0, 0));
        hBox6.setAlignment(Pos.CENTER_LEFT);
        hBox6.getChildren().add(availableTherapists);


        /////////////////////////////////////////
        ////////////////////////////////////////

        HBox hBox7 = new HBox();

        VBox oligoVBox = new VBox();
        oligoPicLbl = new Label("oligo-freno");
        oligoPicLbl.setAlignment(Pos.CENTER);
        oligoPicBtn = new Button();
        oligoPicBtn.setPrefSize(75, 75);
        oligoPicBtn.setId("oligoBtn");

        //ACTION:
        oligoPicBtn.setOnAction(event -> {

            //static value
            currentOccupation = "oligo";

            //choose Therapist View
        });

        oligoVBox.setAlignment(Pos.CENTER);
        oligoVBox.setSpacing(10);
        oligoVBox.getChildren().addAll(oligoPicLbl, oligoPicBtn);

        /********************************
         */

        VBox hipoVBox = new VBox();
        hipoPicLbl = new Label("hippo");
        hipoPicLbl.setAlignment(Pos.CENTER);
        hipoPicBtn = new Button();
        hipoPicBtn.setPrefSize(75, 75);
        hipoPicBtn.setId("hipoBtn");

        // ACTION
       hipoPicBtn.setOnAction(event -> {
           //static value
            currentOccupation = "hipo";
        });

        hipoVBox.setAlignment(Pos.CENTER);
        hipoVBox.setSpacing(10);
        hipoVBox.getChildren().addAll(hipoPicLbl, hipoPicBtn);

        /********************************
         */

        VBox logoVBox = new VBox();
        logoPicLbl = new Label("speech");
        logoPicLbl.setAlignment(Pos.CENTER);
        logoPicBtn = new Button();
        logoPicBtn.setPrefSize(75, 75);
        logoPicBtn.setId("logoBtn");

        // ACTION
        logoPicBtn.setOnAction(event -> {
            //static value
            currentOccupation = "logo";
        });

        logoVBox.setAlignment(Pos.CENTER);
        logoVBox.setSpacing(10);
        logoVBox.getChildren().addAll(logoPicLbl, logoPicBtn);

        /********************************
         */


        VBox waterVBox = new VBox();
        waterPicLbl = new Label("water");
        waterPicLbl.setAlignment(Pos.CENTER);
        waterPicBtn = new Button();
        waterPicBtn.setPrefSize(75, 75);
        waterPicBtn.setId("waterPicBtn");

        // ACTION
        waterPicBtn.setOnAction(event -> {
            //static value
            currentOccupation = "water";
        });

        waterVBox.setAlignment(Pos.CENTER);
        waterVBox.setSpacing(10);
        waterVBox.getChildren().addAll(waterPicLbl, waterPicBtn);

        /********************************
         */

        VBox physioVBox = new VBox();
        physioPicLbl = new Label("physio");
        physioPicLbl.setAlignment(Pos.CENTER);
        physioPicBtn = new Button();
        physioPicBtn.setPrefSize(75, 75);
        physioVBox.setSpacing(10);
        physioPicBtn.setId("physioPicBtn");

        // ACTION
        physioPicBtn.setOnAction(event -> {
            //static value
            currentOccupation = "physio";


        });

        physioVBox.setAlignment(Pos.CENTER);
        physioVBox.getChildren().addAll(physioPicLbl, physioPicBtn);


        /********************************
         */

        hBox7.setPrefWidth(500);
        hBox7.setSpacing(20);
        hBox7.getChildren().addAll(oligoVBox, hipoVBox, logoVBox, waterVBox, physioVBox);

        /********************************
         */

        HBox hBox8 = new HBox();

        nextBtn = new Button("Next");
        nextBtn.setPrefSize(75, 30);
        nextBtn.setLineSpacing(50);
        nextBtn.setAlignment(Pos.CENTER);


        hBox8.setMaxWidth(455);
        hBox8.setPadding(new Insets(10, 0, 0, 0));
        hBox8.setAlignment(Pos.CENTER_RIGHT);
        hBox8.getChildren().add(nextBtn);

        /////////////////////////////////

        HBox hBox1 = new HBox();

        logOutBtn = new Button();
        logOutBtn.setText("LogOut");
        logOutBtn.setPrefWidth(60);


        homeBtn = new Button();
        homeBtn.setText("homeBtn");
        homeBtn.setPrefWidth(60);

        //hBox1.setSpacing(328);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER_LEFT);
        hBox1.setMaxWidth(450);
        hBox1.getChildren().addAll(homeBtn, logOutBtn);


        /////////////////////////////////

        vBoxLeft.setSpacing(20);
        vBoxLeft.setPrefWidth(600);
        vBoxLeft.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8);
        borderPane.setLeft(vBoxLeft);

        ///////////////////////////////


        /**
         *  Border Pane - Right
         */

        VBox vBoxRight = new VBox();



        HBox hBox10 = new HBox();
        disabilitiesLbl = new Label("Diagnosed Disabilities");

        hBox10.setPadding(new Insets(10,10,0,10));
        hBox10.getChildren().add(disabilitiesLbl);

        HBox hBox11 = new HBox();
        disabilitiesTxtArea = new TextArea();
        disabilitiesTxtArea.setPrefSize(500, 1000);

        hBox11.setPadding(new Insets(10,10,0,10));
        hBox11.getChildren().add(disabilitiesTxtArea);


        vBoxRight.getChildren().addAll(hBox10, hBox11);
        borderPane.setRight(vBoxRight);
        borderPane.getRight().prefHeight(550);



        /**
         *  Scene
         */

        Scene scene = new Scene(borderPane, 1200, 640);
        return scene;

    }


    public void start() {

        Stage primary = new Stage();
        Scene scene = startAssociateTherapistChild();
        primary.setScene(scene);
        primary.show();

    }

}
