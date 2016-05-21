package controller;

import javafx.scene.Scene;
import model.DatabaseModel;
import model.User;
import view.LogInView;

/**
 * Created by Grzegorz Goraj on 18-05-2016.
 * email: greg.goray@gmail.com
 */
public class LoginController {
    DatabaseModel databaseModel= new DatabaseModel();
    LogInView logInView = new LogInView();

    public User handleLogin(String email, String password){
        if(databaseModel.retrieveChildIfAllowedToLogIn(email,password)!=null){
            return databaseModel.retrieveChildIfAllowedToLogIn(email,password);
        }
        if(databaseModel.retrieveTherapistIfAllowedToLogIn(email, password)!= null){
            return databaseModel.retrieveTherapistIfAllowedToLogIn(email, password);
        }
        if(databaseModel.retrievePresidentIfAllowedToLogIn(email,password)!= null){
            return databaseModel.retrievePresidentIfAllowedToLogIn(email,password);
        }

    return null;
    }

    public Scene getLoginScene() {
        return logInView.getLoginScene();
    }

}
