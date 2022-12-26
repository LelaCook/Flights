package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogoutController {
	
	@FXML
	private Button yesButton;
	private Button noButton;
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
		public void logout(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	}

}
