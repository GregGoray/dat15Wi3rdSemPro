package controller;

import javafx.scene.Scene;
import model.Database;
import model.User;
import view.LogInView;

/**
 * Created by Grzegorz Goraj on 18-05-2016.
 * email: greg.goray@gmail.com
 */
public class LoginController {
    Database databaseModel= Database.getInstance();
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


}
