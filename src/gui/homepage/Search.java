package gui.homepage;

import gui.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.App;

public class Search extends Controller {

	@FXML private TextField searchBox;
	@FXML private FlowPane results;
	
	public Search() {
	}

	@Override
	public void initialize() {
		
	}
	
	@FXML
	private void search(ActionEvent e) {
		System.out.println("searched");
		System.out.println(searchBox.getText());
		results.getChildren().add(new SearchItem("albert","albro",1.1,this.getApp()));//TODO: search for users
	}

}

class SearchItem extends AnchorPane {
	
	private Label username;
	private Label name;
	private Text rating;
	private App app;
	
	SearchItem(String username, String name, double rating, App app) {
		this.setApp(app);
		
		this.setMaxSize(290.0, 50.0);
		this.setPrefSize(290.0, 50.0);
		this.setStyle("-fx-background-color: azure; -fx-border-color: blue;");
		this.username = new Label();
		this.name = new Label();
		this.rating = new Text();
		
		this.username.setAlignment(Pos.CENTER_RIGHT);
		this.username.setLayoutX(10.0);
		this.username.setLayoutY(12.0);
		this.username.setPrefSize(103.0, 17.0);
		this.username.setPadding(new Insets(0, 5, 0, 0));
		this.username.setText(username);
		
		this.rating.setLayoutX(240.0);
		this.rating.setLayoutY(35.0);
		this.rating.setFont(new Font("Tahoma", 26.0));
		this.rating.setText(Double.toString(rating));
		
		this.name.setLayoutX(113.0);
		this.name.setLayoutY(12.0);
		this.name.setPrefSize(137.0, 17.0);
		this.name.setPadding(new Insets(0, 0, 0, 2));
		this.name.setTextFill(Color.GREY);
		this.name.setText(name);
		
		
		
		
		this.getChildren().add(this.username);
		this.getChildren().add(this.name);
		this.getChildren().add(this.rating);
		
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("hello");
				getApp().getHomePage();
				//TODO: click on a user in search results
			}
		});
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
	
	/*
	 * <AnchorPane maxHeight="50.0" maxWidth="310.0" prefHeight="50.0" prefWidth="310.0" style="-fx-background-color: azure; -fx-border-color: blue;">
                           <children>
                              <Text layoutX="271.0" layoutY="28.0" strokeType="OUTSIDE" strokeWidth="0.0" text="5">
                                 <font>
                                    <Font name="System Bold" size="26.0" />
                                 </font>
                              </Text>
                              <Label layoutX="113.0" layoutY="12.0" prefHeight="17.0" prefWidth="137.0" text="Name" textFill="#868383">
                                 <padding>
                                    <Insets left="2.0" />
                                 </padding>
                              </Label>
                           </children>
                        </AnchorPane>
	 */
	
	
}
