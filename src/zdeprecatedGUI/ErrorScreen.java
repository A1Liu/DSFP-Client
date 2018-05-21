package zdeprecatedGUI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

public class ErrorScreen extends GridPane {

	private final Text message;
	private static final Rectangle box;
	private final StackPane container;
	
	static {	
		box = new Rectangle(300, 250, Paint.valueOf("0000ff"));
	}
	
	public ErrorScreen() {
		this("Error");
	}
	
	public ErrorScreen(String message) {
		container = new StackPane();
		this.message = new Text();
		this.message.setText(message);
		this.setup();
	}
	
	private void setup() {
		container.getChildren().add(box);
		message.setFont(new Font(100));
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(25,25,25,25));
		container.getChildren().add(message);
		this.add(container,0,0);
	}
}
