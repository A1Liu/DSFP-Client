package gui.homepage;

import gui.Controller;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import main.App;

public class Profile extends Controller {

	@FXML private Text username;
	@FXML private Text email;
	@FXML private Text	name;
	@FXML private Text rating;
	
	public Profile() {
	}

	@Override
	public void initialize() {

	}

	
	@Override
	public void setApp(App app) {
		super.setApp(app);
		username.setText(getApp().getUser().getUsername());
		email.setText(getApp().getUser().getEmail());
		name.setText(getApp().getUser().getName());
		rating.setText(Double.toString(1.0));
	}
	
	@FXML
	private void logout() {
		this.getApp().logout();
	}
}
