package zdeprecatedGUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import users.User;

/**
 * 
 * @author aliu
 *
 */
class NewLoginPage extends GridPane {
	
	private Text title;
	private Label userName;
	private TextField userNameText;
	private Label name;
	private TextField nameText;
	private Label email;
	private TextField emailText;
	private Label password;
	private PasswordField pwBox;
	private Label password2;
	private PasswordField pw2Box;
	private Text placeholder;
	private Button btn;
	private Button signin;
	private Controller control;
	private Text errorText;
	
	
	{
        this.setAlignment(Pos.TOP_LEFT);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        this.getColumnConstraints().add(new ColumnConstraints(200));
        this.getColumnConstraints().add(new ColumnConstraints(50));
        
        title = new Text("Create an Account");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        userName = new Label("User Name:");
        
        userNameText = new TextField();
        userNameText.setPromptText("Username");
        
        name = new Label("Name:");
        
        nameText = new TextField();
        nameText.setPromptText("John Doe");

        email = new Label("Email:");

        emailText = new TextField();
        emailText.setPromptText("johnDoe@gmail.com");
        
        password = new Label("Password:");
        
        pwBox = new PasswordField();
        pwBox.setPromptText("StrongPasswordThatCan'tBeHacked");
        
        password2 = new Label("Confirm Password:");

        pw2Box = new PasswordField();
        pw2Box.setPromptText("StrongPasswordThatCan'tBeHacked");
      
        placeholder = new Text("");
        
        btn = new Button();
		btn.setText("Create Account");
		
		signin = new Button();
		signin.setText("Sign In");
		
		errorText = new Text();
        errorText.setFont(new Font(10));
        errorText.setVisible(false);
		
		this.add(title, 0, 0, 2, 1);        
        this.add(userName, 0,1);
        this.add(userNameText, 0, 2,2,1);
        this.add(name, 0,3);
		this.add(nameText, 0, 4,2,1);
		this.add(email, 0,5);
		this.add(emailText, 0, 6,2,1);
		this.add(password, 0, 7);
		this.add(pwBox, 0, 8,2,1);
		this.add(password2, 0, 9);
		this.add(pw2Box, 0, 10,2,1);
        this.add(placeholder,0,11);
		this.add(btn, 1,12,2,1);
        this.add(errorText, 0, 12);
        this.add(signin, 2, 13);
        this.setPrefHeight(100);
	}
	
	public NewLoginPage(Controller c) {
		control = c;
		
		signin.setOnAction(value -> {
			control.loginPage();
		});
		
		btn.setOnAction(var -> {
			String username = userNameText.getText();
			String email = emailText.getText();
			String name = nameText.getText();
        	String password = pwBox.getText();
        	String password2 = pw2Box.getText();
        	
        	if (!password.equals(password2)) {
        		errorText.setText("Passwords don't match!");
        		errorText.setVisible(true);
        		return;
        	}
        	
        	try {
        		if (!control.getApp().getConnection().isConnected()) {
        			control.getApp().getConnection().run();
        			if (!control.getApp().getConnection().isConnected()) {
        				errorText.setText("Can't connect to server.");
        				errorText.setVisible(true);
        				return;
        			}
        		}
        		
        		control.getApp().setUser(control.getApp().login(new User(username, email, name), password));
        		errorText.setVisible(false);
        		control.homePage();
        	} catch (Exception e) {
        		errorText.setText("Username/Email is already taken.");
        		errorText.setVisible(true);
        	}
        });
		
	}
}
