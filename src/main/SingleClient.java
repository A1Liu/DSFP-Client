package main;
import javafx.application.Application;
import javafx.stage.Stage;

public class SingleClient extends Application {

	private static App application;
	
	public static void main(String... args) {
		launch(args);
		application.getConnection().disconnect();
		
	}

	@Override
    public void start(Stage primaryStage) {
		application = new App(primaryStage);
    }
	
	/**
	 * Infinitely loops through the draw and utilities methods.
	 *
	public static void runAnimation() {
		EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				
			}
		};
		Timeline tl = new Timeline(new KeyFrame(Duration.ONE, eh));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}*/
}
