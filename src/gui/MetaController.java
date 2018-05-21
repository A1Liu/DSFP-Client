package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller of controllers
 * @author aliu
 *
 */
public abstract class MetaController extends Controller {

	private FXMLLoader fxmlLoader;
	private Stage window;
	
	public MetaController(Stage primaryStage, FXMLLoader loader) {
		this.window = primaryStage;
		fxmlLoader = loader;
	}
	
	public MetaController(Stage primaryStage) {
		this.window = primaryStage;
		fxmlLoader = new FXMLLoader();
	}
	
	/**
	 * sets the scene
	 * @param root scene to set
	 */
	public void setScene(Parent root) {
		window.setScene(new Scene(root));
	}
	
	/**
	 * setter for stage
	 * @param window stage
	 */
	void setStage(Stage window) {
		this.window = window;
	}
	/**
	 * getter for stage
	 * @return stage
	 */
	public Stage getStage() {
		return window;
	}
	
	/**
	 * Loads and displays the page at the specified location, and returns the controller object associated with it
	 * @param location location of page's fxml file
	 * @return the controller for that page
	 */
	protected Controller getPage(String location) {
		try {
			fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getURL(location));
			setScene(fxmlLoader.load());
			Controller controller = (Controller) fxmlLoader.getController();
			fxmlLoader.setLocation(null);
			return controller;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static URL getURL(String url) {
		try {
			return new File(url).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public FXMLLoader getLoader() {
		return fxmlLoader;
	}
	
	void setLoader(FXMLLoader loader) {
		fxmlLoader = loader;
	}
}
