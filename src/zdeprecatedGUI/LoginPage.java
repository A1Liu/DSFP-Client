package zdeprecatedGUI;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
import javafx.scene.text.*;

/**
 * 
 * @author aliu
 *
 */
class LoginPage extends GridPane {
	
	private Controller control;
	private Text scenetitle;
	private Label userName;
	private TextField userTextField;
	private Label pw;
	private PasswordField pwBox;
	private Button btn;
	private HBox hbBtn;
	private Text errorText;
	private Button newbtn;
	private HBox newhbBtn;
	
	{
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        

        scenetitle = new Text("Sign in");

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.add(scenetitle, 0, 0, 2, 1);

        userName = new Label("User Name:");
        this.add(userName, 0, 1);

        userTextField = new TextField();
        userTextField.setPromptText("Username");
        this.add(userTextField, 1, 1,3,1);

        pw = new Label("Password:");
        this.add(pw, 0, 2);

        pwBox = new PasswordField();
        pwBox.setPromptText("Password");
        this.add(pwBox, 1, 2,3,1);
        
        //Sign in button
        btn = new Button("Sign in");
        hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        this.add(hbBtn, 3, 4);
        
        errorText = new Text();
        errorText.setFont(new Font(10));
        errorText.setVisible(false);
        this.add(errorText, 0, 4,2,1);
        
        newbtn = new Button("Sign up");
        newhbBtn = new HBox(10);
        newhbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        newhbBtn.getChildren().add(newbtn);
        this.add(newhbBtn, 3, 6);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent a) {
            	
            	String username = userTextField.getText();
            	String password = pwBox.getText();
            	try {
            		if (!control.getApp().getConnection().isConnected()) {
            			control.getApp().getConnection().run();
            			if (!control.getApp().getConnection().isConnected()) {
            				errorText.setText("Can't connect to server.");
            				errorText.setVisible(true);
            				return;
            			}
            		}
            		
            		control.getApp().setUser(control.getApp().login(username, password));
            		errorText.setVisible(false);
            		control.homePage();
            	} catch (Exception e) {
            		errorText.setText("Incorrect login credentials.");
            		errorText.setVisible(true);
            		e.printStackTrace();
            	}
            }
        });
        
        newbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				control.newLoginPage();
			}
        });
	}
	

	public LoginPage(Controller c) {
		control = c;
	}
	
	
	
}
