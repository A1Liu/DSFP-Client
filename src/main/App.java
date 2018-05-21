package main;

import connection.clientRequests.*;
import connection.clientRequests.Logout;
import connection.serverPackets.ServerPacket;
import gui.HomePage;
import gui.MetaController;
import javafx.stage.Stage;
import server.ClientException;
import server.Connection;
import users.User;

/**
 * handles GUI logic, decides what is displayed, etc.
 * @author liu_albert
 *
 */
public class App extends MetaController {

	private Connection connection;
	private User user;
	private boolean isHome;
	private HomePage homepage;
	
	public App () {
		this(new Stage());
	}
	
	public App (Stage primaryStage) {
		this(primaryStage, null);
		startup();
	}
	
	public App (Stage primaryStage, User user) {
		super(primaryStage);
		this.user = user;
		connection = new Connection();
		this.setApp(this);
		isHome = false;
	}
	
	public void startup() {
		connection.start();
		this.getLoginPage();
		this.getStage().show();
	}
	/** go to login page */
	public void getLoginPage() {
		isHome = false;
		this.getPage("gui/login.fxml").setApp(this);}
	
	/** go to new user page */
	public void getNewLoginPage() {
		isHome = false; 
		this.getPage("gui/newLogin.fxml").setApp(this);}
	public HomePage getHomePage() {
		if (!isHome) {
			homepage = (HomePage) this.getPage("gui/homePage.fxml");
			homepage.setApp(this);
			isHome = true;
			return homepage;
		} else {
			return homepage;
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean tryConnect() {
		if (!connection.isConnected()) {
			connection.run();
			if (!connection.isConnected()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Login as a new user
	 * @param user
	 * @param password
	 * @return
	 */
	public User login(User user, String password) {
		connection.sendPacket(new LoginNewUser(user, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			this.user = (User) packet.getData()[0];
			return user;
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	/**
	 * login as an existing user
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		connection.sendPacket(new LoginExistUser(username, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			user = (User) packet.getData()[0];
			return user;
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	public User changeInfo(User user) {
		connection.sendPacket(new ChangeInfo(user));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			this.user = (User) packet.getData()[0];
			return user;
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	public String changePass(String oldPass, String newPass) {
		connection.sendPacket(new ChangePass(oldPass,newPass));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			return packet.getData()[0].toString();
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	/** getter for connection
	 * @return connection object*/
	public Connection getConnection() {
		return connection;}
	/** getter for user 
	 * @return user*/
	public User getUser() {
		return user;}
	/** setter for user 
	 * @param user user to set*/
	public void setUser(User u) {
		this.user = u;}
	/** log out of account */
	public void logout() {
		//connection.sendPacket(); TODO: logout
		connection.sendPacket(new Logout());
		ServerPacket packet = connection.receivePacket();
		if (packet != null && packet.getTag() != -1) {
			user = null;
			this.getLoginPage();
		} else {
			user = null;
			this.getLoginPage();
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	/** check if logged in 
	 * @return true if logged in*/
	public boolean loggedIn() {
		return user != null;}

	@Override
	public void initialize() {
		
	}

	public HomePage getHomepage() {
		return homepage;
	}

	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}
}
