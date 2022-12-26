package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	private TextField tf_username;
	private Button button; 
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void goToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void goToLoginSubmit (ActionEvent event) throws SQLException {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		try {
		String database = "INSERT INTO UserAccounts (username,password,securitynswer) VALUES (hi,hi,hi)";
		Statement statement = connection.createStatement();
		ResultSet queryResult = statement.executeQuery(database);
		
		}
		
		
		
		
		
		catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}
