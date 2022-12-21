package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void register (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Register.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		///System.out.println("HI");
	}
	public void login (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Search.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		///System.out.println("HI");
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
	
	