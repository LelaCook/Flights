package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminRegisterController {
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_password;
	@FXML
	private TextField tf_security_answer;
	private Label message;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	//once info is inserted, press log in to log in with new credentials which are now in databse 
	public void goToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/AdminLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//insert info and click submit in oder for it to go to database

	public void addToAdminAccounts (ActionEvent event) throws SQLException {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		try {
			//insert into admin account
			String database = "INSERT INTO AdminAccounts (username,password,securityanswer) VALUES (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(database);
		
			statement.setString(1, tf_username.getText());
			statement.setString(2, tf_password.getText());
			statement.setString(3, tf_security_answer.getText());
	
			System.out.println("inserted into admin accts");
			statement.executeUpdate();
			
			//statement.setString(1, "hi");
			//statement.setString(2, "hello");
			//statement.setString(3, "bye");
			
			statement.executeUpdate();
			
			message.setText("Account Created");
			System.out.println("inserted");

		}catch (Exception e) {
			e.printStackTrace();
			e.getCause(); 
		}
		
		try {
			String data = "INSERT INTO UserAccounts (username,password,securityanswer) VALUES (?,?,?)";
			PreparedStatement stat = connection.prepareStatement(data);
		
			stat.setString(1, tf_username.getText());
			stat.setString(2, tf_password.getText());
			stat.setString(3, tf_security_answer.getText());
		
			System.out.println("inserted");
			
			stat.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
	}

}
