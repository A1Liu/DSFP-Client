package zdeprecatedGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import users.User;

class HomeProfilePage extends GridPane {
	
	private Controller control;
	private User user;
	private Text usernameField;
	private Text nameField;
	private Button btn;
	private HBox hbBtn;

	
	{
        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        btn = new Button("logout");
        hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
			public void handle(ActionEvent event) {
        		control.getApp().logout();
				control.loginPage();
			}
        });
	}
	
	public HomeProfilePage(Controller c, User user) {
		this.control = c;
		this.user = user;
		setup();
	}
	
	public void setup() {
		String username = user.getUsername();
        String name = user.getName();

        usernameField = new Text(username);
        usernameField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        nameField = new Text(name);
        nameField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        this.add(usernameField, 0, 0);
        this.add(nameField, 0, 1);
        this.add(hbBtn, 0, 2);
	}

}
