package view;

import controller.TherapistResumeController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.TherapistResume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


/**
 * Created by Grzegorz Goraj on 26-05-2016.
 * email: greg.goray@gmail.com
 */
public class TherapistResumeView {

    private BorderPane borderPane;

    private VBox mainvBox1;
    private VBox mainVBox2;
    private VBox mainVBox3;


    private Label profilePicture;
    private Label certificationLbl;
    private Label certificationTextLbl;
    private Label summaryLbl;
    private Label summaryTextLbl;
    private Label highlightsLbl;
    private Label highlightsTextLbl;
    private Label educationLbl;
    private Label educationTextLbl;
    private Label workExperienceLbl;
    private Label workExperienceTextLbl;


    private TherapistResumeController therapistResumeController = new TherapistResumeController();
    private TherapistResume resume = therapistResumeController.getResumeByTherapistId();




    public Scene viewResume() {

        /**
         *  Source of Resume's Text:
         */


        /**
         *  Root Panel
         */
        borderPane = new BorderPane();


        /**
         *   main VBox1
         */


        mainvBox1 = new VBox();

        /**
         *  profile picture
         */

        HBox hBox1 = new HBox();
            hBox1.setPrefSize(100, 120);
            profilePicture = new Label();
            String path = "./src\\main\\Resources\\TherapyDefault\\therapist1.jpg";
            File file = new File(path);
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image profilePic = new Image(fis);
            ImageView imageView = new ImageView();
            imageView.setImage(profilePic);
            profilePicture.setGraphic(imageView);
            hBox1.setPadding(new Insets(5,5,5,5));
        hBox1.getChildren().add(profilePicture);


        HBox hBox2 = new HBox();

            VBox vBox1 = new VBox();

                certificationTextLbl = new Label();
                certificationTextLbl.setText("Certification:");
                certificationTextLbl.setStyle("-fx-font-weight: bold");

                String certificationTxt = (resume.getCertification());
                certificationLbl = new Label();
                certificationLbl.setText(certificationTxt);
                certificationLbl.setWrapText(true);
            vBox1.getChildren().addAll(certificationTextLbl, certificationLbl);


        hBox2.getChildren().addAll(vBox1);
        hBox2.setPadding(new Insets(5,5,5,5));


        mainvBox1.setSpacing(20);
        mainvBox1.setMaxSize(300, 800);
        mainvBox1.setStyle("-fx-background-color: #e2e1e1");
        mainvBox1.setPadding(new Insets(5,5,5,5));
        mainvBox1.getChildren().addAll(hBox1, hBox2);


        /**
         *  main VBox2
         */

        mainVBox2 = new VBox();

        /**
         *  summary
         */


        HBox hBox3 = new HBox();

            VBox vBox2 = new VBox();
                summaryTextLbl = new Label();
                summaryTextLbl.setText("Summary");
                summaryTextLbl.setStyle("-fx-font-weight: bold");

                summaryLbl = new Label();
                String summaryTxt = resume.getSummary();
                summaryLbl.setText(summaryTxt);
                summaryLbl.setWrapText(true);
            vBox2.getChildren().addAll(summaryTextLbl, summaryLbl);

        hBox3.getChildren().add(vBox2);
        hBox3.setSpacing(10);


        /**
         *  highlights
         */

        HBox hBox4 = new HBox();

            VBox vBox3 = new VBox();
                highlightsTextLbl = new Label("Highlights");
                highlightsTextLbl.setStyle("-fx-font-weight: bold");

                highlightsLbl = new Label();
                String highlightsTxt = resume.getHighlights();
                highlightsLbl.setText(highlightsTxt);
                highlightsLbl.setWrapText(true);
            vBox3.getChildren().addAll(highlightsTextLbl, highlightsLbl);
        hBox4.getChildren().addAll(vBox3);


        /**
         * education
         */


        HBox hBox5 = new HBox();

            VBox vBox4 = new VBox();
                educationTextLbl = new Label("Education:");
                educationTextLbl.setStyle("-fx-font-weight: bold");

                educationLbl = new Label();
                String educationTxt = resume.getEducation();
                educationLbl.setText(educationTxt);
                educationLbl.setWrapText(true);
            vBox4.getChildren().addAll(educationTextLbl, educationLbl);

        hBox5.getChildren().addAll(vBox4);

        mainVBox2.setPrefHeight(800);
        mainVBox2.setSpacing(15);
        mainVBox2.setStyle("-fx-background-color: #e2e1e1");
        mainVBox2.setPadding(new Insets(10,10,10,10));
        mainVBox2.getChildren().addAll(hBox3, hBox4, hBox5);


        /**
         *  main VBox3
         */

        mainVBox3 = new VBox();
            HBox hBox6 = new HBox();
                VBox vBox5 = new VBox();
                    workExperienceTextLbl = new Label("Work Experience:");
                    workExperienceTextLbl.setStyle("-fx-font-weight: bold");
                    workExperienceLbl = new Label();
                    workExperienceLbl.setText(resume.getWorkExperience());
                    workExperienceLbl.setWrapText(true);
                vBox5.getChildren().addAll(workExperienceTextLbl, workExperienceLbl);
            hBox6.getChildren().addAll(vBox5);
        mainVBox3.setStyle("-fx-background-color: #e2e1e1");
        mainVBox3.setPadding(new Insets(5,5,5,5));
        mainVBox2.setMaxHeight(800);
        mainVBox3.getChildren().addAll(hBox6);



        borderPane.setLeft(mainvBox1);
        borderPane.setCenter(mainVBox2);
        borderPane.setRight(mainVBox3);


        borderPane.setMargin(mainvBox1, new Insets(10,10,10,10));
        borderPane.setMargin(mainVBox3, new Insets(10,10,10,10));
        borderPane.setPadding(new Insets(20,20,20,20));




        Scene scene = new Scene(borderPane, 1200, 800);
       return scene;

    }


}
