package zdeprecatedGUI;

import javafx.scene.layout.GridPane;


class LoadingPage extends Page {

	private static GridPane grid;
	
	static {
		grid = new GridPane();
	}
	
	protected LoadingPage(Controller control) {
		super(grid, control);
	}

}
