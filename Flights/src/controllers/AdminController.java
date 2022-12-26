package controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {
	
	@FXML
	private Button addButton;
	private Button deleteButton;
	private TextField flightId;
	private TextField capacity;
	private TextField cityFrom;
	private TextField cityto;
	private TextField idToDelete;
	private DatePicker depart;
	private DatePicker arrive;
	
	public void add (ActionEvent event) throws IOException, SQLException  {
		
	}
	
	public void delete (ActionEvent event) throws IOException, SQLException {
		
	}
	
	public void back (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
