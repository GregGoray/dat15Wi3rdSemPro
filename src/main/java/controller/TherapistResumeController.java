package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Database;
import model.Therapist;
import model.TherapistResume;
import view.TherapistResumeView;

import java.util.ArrayList;

/**
 * Created by Grzegorz Goraj on 24-05-2016.
 * email: greg.goray@gmail.com
 */
public class TherapistResumeController {

    private Database db = Database.getInstance();


    /**
     * getting therapists of certain kind from database
     * @param
     */

    public ArrayList<Therapist> getTherapistsByOccupation() {

        ArrayList<Therapist> listByOccupation = db.getTherapistsByOccupation();

        return listByOccupation;
    }

    public TherapistResume getResumeByTherapistId() {

        ArrayList<String> resumeAttributes = new ArrayList<>();
        Database db = Database.getInstance();
        TherapistResume resume = db.getResumeByTherapistId(1);
        return resume;

    }

    public void startResumeView() {
        TherapistResumeView resumeVIew = new TherapistResumeView();
        Stage primaryStage = new Stage();
        Scene scene = resumeVIew.viewResume();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Resume");
        primaryStage.show();
    }


}
