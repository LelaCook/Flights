package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label label_login_message;
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_password;
	
	
	
	
	public void register (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Register.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		///System.out.println("HI");
	}
	
	
	
	
	public void login (ActionEvent event) throws IOException {
		//if statement below will eventually be changed
		//if tf_username and tf_password matches username and password in database .. then execute line 53-57(go to search page)
		if(tf_username.getText().isBlank()== false && tf_password.getText().isBlank()==false) {
		
			Parent root = FXMLLoader.load(getClass().getResource("../gui/Search.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
		
		}else {
			label_login_message.setText("Invalid login. Try again.");
		}
	}
	
			
	

	public void forgotPassword (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Forgot.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		///System.out.println("HI");
}

		
	}

	
	