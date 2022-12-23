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

public class SearchController {
	
	@FXML
	private Button searchButton;
	private Button logoutButton;
	private Button accountButton;
	private Button addButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void logOut(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToAccount(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/gui/Account.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void add(ActionEvent event) throws IOException, SQLException {
		
	}
	
	public void search(ActionEvent event) throws IOException, SQLException {
		
	}

}
