package zdeprecatedGUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.App;

import static util.Const.*;
import static zdeprecatedGUI.Page.*;

/**
 * handles GUI logic, decides what is displayed, etc.
 * @author liu_albert
 *
 */
public class Controller {

	private Stage window;
	private App app;
	
	public Controller(App application) {
		this.app = application;
		this.window = application.getStage();
	}
	
	//Methods to set the scene and show it.
	public void display(Parent root) {
		window.setScene(new Scene(root, WIDTH, HEIGHT));
	}
	public void loginPage() {window.setScene(getLoginPage(this));}
	public void newLoginPage() {window.setScene(getNewLoginPage(this));}
	public void homePage() {window.setScene(getHomePage(this));}
	public void show() {window.show();}
	
	public App getApp() {
		return app;
	}
}
