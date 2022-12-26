package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private TextField tf_username;
	private TextField tf_password;
	
	public void register(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Register.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void admin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void login (ActionEvent event) throws IOException, SQLException {
		//connect to db
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		//create string (verifyLogin) that will compare user input to database attributes
		String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + tf_username.getText() + "' AND password = '" + tf_password.getText() + "'";
		
		try {
			//executes verifyLogin statement and store results in queryResult
			Statement statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			
			//turn queryResult into int and test if its 1 (if theres a match), if so go to search page
			while (queryResult.next()) {
				if (queryResult.getInt(1)==1) {
					Parent root = FXMLLoader.load(getClass().getResource("../gui/Searches.fxml"));
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
			}
				// if not, print error message	
				else {
				
					label_login_message.setText("Invalid login. Please try again");
			}	
		}
			
		}catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void forgotPassword (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Forgot.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}