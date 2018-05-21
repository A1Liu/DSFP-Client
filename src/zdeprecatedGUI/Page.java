package zdeprecatedGUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import static util.Const.HEIGHT;
import static util.Const.WIDTH;

/**
 * 
 * @author aliu
 *
 */
class Page extends Scene {

	private Controller control;
	
	public Page(Parent root, Controller control) {
		super(new StackPane(), WIDTH, HEIGHT);
		((StackPane) this.getRoot()).getChildren().add(root);
		this.setController(control);
	}

	public Controller getController() {
		return control;
	}

	protected void setController(Controller control) {
		this.control = control;
	}
	
	public static Page getLoginPage(Controller c) {
		return new Page(new LoginPage(c),c);
	}

	public static Page getNewLoginPage(Controller c) {
		return new Page(new NewLoginPage(c),c);
	}
	
	public static Page getHomePage(Controller c) {
		return new HomePage(new HomeProfilePage(c,c.getApp().getUser()),c);
	}
	
	
	
}
