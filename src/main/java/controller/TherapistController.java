package controller;

import view.AbstractView;
import javafx.scene.Scene;

/**
 * Created by Kuba on 2016-05-19.
 */
public class TherapistController {
    AbstractView abstractView= new AbstractView();

    public Scene createTherapistView(){
        return abstractView.createAvailabilityView();
    }

}
