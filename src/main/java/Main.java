import controller.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Grzegorz Goraj on 21-05-2016.
 * email: greg.goray@gmail.com
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new Stage();
        Scene scene = getScene();
        primaryStage.setScene(getScene());
        primaryStage.show();
    }


    public Scene getScene() {
        LoginController loginController = new LoginController();
        Scene loginScene = loginController.getLoginScene();
        return loginScene;
    }
}
