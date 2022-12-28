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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController {
	
	@FXML 
	private Button button_back;
	private Button button_logout;
	//private Button deleteButton;
	private Button button_refresh;
	//private TextField flightId;
	//private TableView yourFlight;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Searches.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void logout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void refresh(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Account.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void delete(ActionEvent event) throws IOException, SQLException {
		
	}

}
