package zdeprecatedGUI;


import connection.clientRequests.LoginExistUser;
import connection.clientRequests.LoginNewUser;
import connection.serverPackets.ServerPacket;
import javafx.stage.Stage;
import server.ClientException;
import server.Connection;
import users.User;

/**
 * Contains the app logic for a single instance of the application.
 * Has methods to connect back end to front end
 * @author Alyer
 *
 */
public class App {
	
	private final Stage window;
	private final Controller gui;
	private Connection connection;
	private User user;
	private boolean loggedIn;
	
	public App() {
		window = null;
		gui = null;
	}
	
	
//	public App() {
//		this(new Stage());
//	}
//	
//	public App(Stage primaryStage) {
//		this(primaryStage, null);
//		loggedIn = false;
//		startup();
//	}
//	
//	public App(Stage primaryStage, User user) {
//		this.user = user;
//		primaryStage.setTitle("MEOWMEOWBEENZ");
//		primaryStage.setResizable(false);
//		window = primaryStage;
//		gui = new Controller(this);
//		connection = new Connection();
//		loggedIn = true;
//	}
	
	public void startup() {
		connection.start();
		gui.loginPage();
        gui.show();
	}
	
	public Stage getStage() {
		return window;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public User login(User user, String password) {
		connection.sendPacket(new LoginNewUser(user, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			loggedIn = true;
			return (User) packet.getData()[0];
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	public User login(String username, String password) {
		connection.sendPacket(new LoginExistUser(username, password));
		ServerPacket packet = connection.receivePacket();
		if (packet.getTag() != -1) {
			loggedIn = true;
			return (User) packet.getData()[0];
		} else {
			throw new ClientException(packet.getData()[0].toString());
		}
	}
	
	public Controller getController() {
		return gui;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
	
	public void logout() {
		user = null;
		loggedIn = false;
	}
	
	public boolean loggedIn() {
		return loggedIn;
	}
	
	
}
