package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Database;
import model.Therapist;
import view.ChooseTherapistView;
import view.CreateChildProfileView;

import java.util.ArrayList;

/**
 * Created by Grzegorz Goraj on 24-05-2016.
 * email: greg.goray@gmail.com
 */
public class ChooseTherapistController {

    private Database db = Database.getInstance();
   public static String currentOccupation = CreateChildProfileView.currentOccupation;

    /**
     * Method returns list of therapists of suggested profession
     * @return
     */

    public ObservableList<Therapist> getTherapistsByProfession() {

        // getting list of all therapists from Db
        ArrayList<Therapist> selectedTherapists = db.getTherapistsByOccupation();

        ObservableList<Therapist> therapistsOfProfession = FXCollections.observableArrayList(selectedTherapists);

        return therapistsOfProfession;
    }






}
