package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * 
 * @author aliu
 *
 */
public class Login extends Controller {
	
	@FXML private TextField userText;
	@FXML private PasswordField passText;
	@FXML private Label errorText;
	
	public Login() {
		
	}
	
	@Override
	public void initialize() {
		
	}
	
	
	@FXML
	private void signIn() {
    	String username = userText.getText();
    	String password = passText.getText();
    	try {
    		if (!getApp().getConnection().isConnected()) {
    			getApp().getConnection().run();
    			if (!getApp().getConnection().isConnected()) {
    				errorText.setText("Can't connect to server.");
    				errorText.setVisible(true);
    				return;
    			}
    		}
    		
    		getApp().setUser(getApp().login(username, password));
    		errorText.setVisible(false);
    		getApp().getHomePage();
    	} catch (Exception e) {
    		errorText.setText(e.getMessage());//"Incorrect login credentials."
    		errorText.setVisible(true);
    		e.printStackTrace();
    	}
//    
	}
	
	@FXML
	private void newAccount() {
		this.getApp().getNewLoginPage();
	}




	
	
	
	
	
}
