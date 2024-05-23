package com.rgt.training.session2basics.libraryjavafx.fx;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		String filePath = "libraryfx"; // Replace with the actual file path
		LibraryController libraryController = new LibraryController(filePath);
		LibraryManagementSystemView libraryManagementSystemView = new LibraryManagementSystemView(libraryController);
		libraryManagementSystemView.show();
	}

}
