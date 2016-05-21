package controller;

import javafx.scene.Scene;
import view.PresidentManageTherapistView;

/**
 * Created by Grzegorz Goraj on 21-05-2016.
 * email: greg.goray@gmail.com
 */
public class PresidentManageTherapistController {

    PresidentManageTherapistView presidentManageTherapistView = new PresidentManageTherapistView();

    public Scene getScenepresidentManageTherapistView() {
        return presidentManageTherapistView.getScene();
    }
}
