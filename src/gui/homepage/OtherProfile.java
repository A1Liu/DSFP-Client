package gui.homepage;

import gui.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import main.App;
import users.User;

public class OtherProfile extends Controller {

	@FXML private Text username;
	@FXML private Text name;
	@FXML private Text rating;
	@FXML private Label errorText;
	
	public OtherProfile() {
		
	}

	@Override
	public void initialize() {

	}
	
	public void setup(App app, User user) {
		setApp(app);
		username.setText(user.getUsername());
		name.setText(user.getName());
		rating.setText(user.getRating() == null ? "1.0" : Double.toString(Math.floor(user.getRating()*10)/10));
	}
	
	private void rate(int rating) {
		
	}
	
	@FXML
	private void rate1() {
		rate(1);
	}
	@FXML
	private void rate2() {
		rate(2);
	}
	@FXML
	private void rate3() {
		rate(3);
	}
	@FXML
	private void rate4() {
		rate(4);
	}
	@FXML
	private void rate5() {
		rate(5);
	}

}
