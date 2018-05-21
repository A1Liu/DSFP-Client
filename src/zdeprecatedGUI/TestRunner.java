package zdeprecatedGUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import main.App;

/**
 * 
 * @author aliu
 *
 */
public class TestRunner extends Application {

	public static void main(String... args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) throws IOException {
		@SuppressWarnings("unused")
		App app = new App(primaryStage);//, new User("alyert","alyert.kid@gmail.com","albert")
		primaryStage.show();
    }

}
