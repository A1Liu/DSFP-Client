package zdeprecatedGUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class LoginPage2 extends Page {

	public LoginPage2(Controller control) {
		super(null, control);
		try {
			this.setRoot(FXMLLoader.load(getClass().getResource("login.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
