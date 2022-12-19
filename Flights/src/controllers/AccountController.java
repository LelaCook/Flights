package controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccountController {
	
	@FXML 
	private Button backButton; 
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void goToBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/gui/Search.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
