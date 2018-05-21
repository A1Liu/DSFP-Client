package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users.User;

/**
 * 
 * @author aliu
 *
 */
public class NewLogin extends Controller {

	@FXML private TextField username;
	@FXML private TextField email;
	@FXML private TextField name;
	@FXML private PasswordField password;
	@FXML private PasswordField confirmPassword;
	@FXML private Label errorText;
	
	public NewLogin() {
		
	}

	@Override
	public void initialize() {
		
	}
	
	@FXML
	private void newLogin() {
		
		String username = this.username.getText();
		String email = this.email.getText();
		String name = this.name.getText();
    	String password = this.password.getText();
    	String confirmPassword = this.confirmPassword.getText();
    	
    	if (!password.equals(confirmPassword)) {
    		errorText.setText("Passwords don't match!");
    		errorText.setVisible(true);
    		return;
    	}
    	
    	try {
    		if (!getApp().getConnection().isConnected()) {
    			getApp().getConnection().run();
    			if (!getApp().getConnection().isConnected()) {
    				errorText.setText("Can't connect to server.");
    				errorText.setVisible(true);
    				return;
    			}
    		}
    		
    		getApp().login(new User(username, email, name), password);
    		errorText.setVisible(false);
    		getApp().getHomePage();
    	} catch (Exception e) {
    		errorText.setText(e.toString());//"Username/Email is already taken."
    		errorText.setVisible(true);
    	}

	}
	
	@FXML
	private void hasAccount() {
		this.getApp().getLoginPage();
	}
	
	
	
}