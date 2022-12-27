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


public class AdminController {
	
	@FXML
	private TextField tf_flightid;
	@FXML
	private TextField tf_capacity;
	@FXML
	private TextField tf_tocity;
	@FXML
	private TextField tf_fromcity;
	@FXML
	private TextField tf_id_delete;


	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void add (ActionEvent event) throws SQLException  {
			Connection connection = DriverManager.getConnection
					("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			try {
			String b = "INSERT INTO Flightts (flightid, capacity, tocity, fromcity) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(b);
		
			//wont work when i try to get tf from user (look below)
			
			statement.setString(1, tf_flightid.getText());
			statement.setString(2, tf_capacity.getText());
			statement.setString(3, tf_tocity.getText());
			statement.setString(4, tf_fromcity.getText());
	
			System.out.println("Inserted");
			
			statement.executeUpdate(); 
			

			}catch (Exception e) {
				e.printStackTrace();
				e.getCause(); }
	}
	public void delete (ActionEvent event) throws SQLException  {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		try {
		String b = "DELETE from Flightts where flightid = (?)";
		PreparedStatement statement = connection.prepareStatement(b);
		
		//wont work when i try to get tf from user (look below)
		
		statement.setString(1, tf_id_delete.getText());
	

		System.out.println("Deleted");
		
		statement.executeUpdate(); 
		

		}catch (Exception e) {
			e.printStackTrace();
			e.getCause(); }
		
	}
		
	public void back (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
