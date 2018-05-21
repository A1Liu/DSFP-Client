package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.App;
import server.Connection;
import users.User;

public class HomePage extends MetaController {

	private User user;
	private App app;
	@FXML private BorderPane homepage;
	private int current;
	
	public HomePage() {
		super(null,null);
		current = -1;
	}
	
	public void setApp(App app) {
		this.user = app.getUser();
		this.app = app;
		this.setLoader(new FXMLLoader());
		this.profile();
	}
	
	@FXML
	private void profile() {
		if (current != 3) {
			current = 3;
			this.getProfile();
		}
		
	}
	
	@FXML
	private void settings() {
		if (current != 4) {
			current = 4;
			this.getSettings();
		}
	}
	
	@FXML
	private void search() {
		if (current != 1) {
			current = 1;
			this.getSearch();
		}
		
	}
	
	@FXML
	private void ratings() {
		if (current != 2) {
			current = 2;
			this.getSearch();
		}
	}
	
	public void getProfile() {
		this.getPage("gui/profile.fxml").setApp(app);
	}
	
	public void getSettings() {
		this.getPage("gui/settings.fxml").setApp(app);
	}
	
	public void getSearch() {
		this.getPage("gui/search.fxml").setApp(app);
	}
	
	public void getRatings() {//TODO: ratings page
		//this.getPage("gui/ratings.fxml").setApp(app);
	}
	
	public Controller getPage(String location) {
		try {
			setLoader(new FXMLLoader());
			getLoader().setLocation(getURL(location));
			homepage.setCenter(getLoader().load());
			Controller controller = (Controller) getLoader().getController();
			getLoader().setLocation(null);
			return controller;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void logout() {
		app.logout();
	}
	
	
	
	public User getUser() {
		return user;
	}
	
	public Connection getConnection() {
		return app.getConnection();
	}
	
	public Stage getStage() {
		return app.getStage();
	}

	@Override
	public void initialize() {
		
	}
	
	

	

}
