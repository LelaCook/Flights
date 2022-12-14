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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdminController {
	
	@FXML
	private TextField tf_flightid;
	@FXML
	private TextField tf_tocity;
	@FXML
	private TextField tf_fromcity;
	@FXML
	private TextField tf_id_delete;
	@FXML
	private TextField dp_depart;
	@FXML
	private TextField dp_arrive;
	@FXML
	private TextField tf_arrivetime;
	@FXML
	private TextField tf_departtime;
	@FXML
	private Label message;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void add (ActionEvent event) throws SQLException  {
			Connection connection = DriverManager.getConnection
					("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			try {
				String b = "INSERT INTO FINALFLIGHTS2 (flightid, tocity, fromcity, departdate, arrivedate, arrivetime, departtime) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(b);
			
				//wont work when i try to get tf from user (look below)
				
				statement.setString(1, tf_flightid.getText());
				
				statement.setString(2, tf_tocity.getText());
				statement.setString(3, tf_fromcity.getText());
				statement.setString(4, dp_depart.getText());
				statement.setString(5, dp_arrive.getText());
				statement.setString(6, tf_arrivetime.getText());
				statement.setString(7, tf_departtime.getText());
	
				statement.executeUpdate(); 
				System.out.println("Inserted");
				message.setText("Added!");
				
			}catch (Exception e) {
				e.printStackTrace();
				e.getCause(); }
	}
	
	public void delete (ActionEvent event) throws SQLException  {
		Connection connection = DriverManager.getConnection
			("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		try {
			String b = "DELETE from FINALFLIGHTS2 where flightid = (?)";
			PreparedStatement statement = connection.prepareStatement(b);
			
			//wont work when i try to get tf from user (look below)
			
			statement.setString(1, tf_id_delete.getText());
		
			statement.executeUpdate(); 
			System.out.println("Deleted");
			message.setText("Flight Deleted!");

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause(); 
		}
	}
		
	public void back (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminLogout.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void refresh (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Admin.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void all (ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../gui/AdminSearches.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
