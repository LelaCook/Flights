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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_password;
	@FXML
	private TextField tf_security_answer;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public static Connection getConnection() throws SQLException{
			String database = "jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			Connection connection = DriverManager.getConnection(database);
			System.out.print("connection established");
			
			return connection;
		
	}
	
	
	//once info is inserted, press log in to log in with new credentials which are now in databse 
	public void goToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
//insert info and click submit in oder for it to go to database
	public void goToLoginSubmit (ActionEvent event) throws SQLException {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		try {
		String database = "INSERT INTO UserAccounts (username,password,securityanswer) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(database);
	
		//wont work when i try to get tf from user (look below)
		statement.setString(1, tf_username.getText());
		statement.setString(2, tf_password.getText());
		statement.setString(3, tf_security_answer.getText());
		
		
		
		//statement.setString(1, "hi");
		//statement.setString(2, "hello");
		//statement.setString(3, "bye");
		
		System.out.println("inserted");
		
		statement.executeUpdate();
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
			e.getCause();			
		
		} 
		String user = tf_username.getText();
		
		try {
		Connection conn = getConnection();
		PreparedStatement stat = conn.prepareStatement("CREATE TABLE " + user + " (flightid varchar(20))");
				//(flightid VARCHAR(20) INT NOT NULL, fromcity VARCHAR(20) INT NOT NULL)";
		
		stat.executeUpdate();
		
		//wont work when i try to get tf from user (look below)
		
		//statement.setString(1, "hi");
		//statement.setString(2, "hello");
		//statement.setString(3, "bye");
		
		System.out.println("inserted");
		
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			e.getCause();
			
			
			
		}
	}
}
