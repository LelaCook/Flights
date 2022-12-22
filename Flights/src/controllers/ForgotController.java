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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotController {
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_security_answer;
	@FXML
	private Label label_password_message;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void backToLogin (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

}
	
		


	public void revealPassword (ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
		//connect to db
				Connection connection = DriverManager.getConnection
						("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				
				
				String verifyAnswer = "SELECT count(1) FROM UserAccounts WHERE username = '" + tf_username.getText() + "' AND securityanswer = '" + tf_security_answer.getText() + "'";
				String verifyAnswer2 = "SELECT password FROM UserAccounts WHERE username = '" + tf_username.getText() + "' AND securityanswer = '" + tf_security_answer.getText() + "'";
				
				try {
					
					Statement statement = connection.createStatement();
					ResultSet queryResult = statement.executeQuery(verifyAnswer);
					
					
					while (queryResult.next()) {
						if (queryResult.getInt(1)==1) {
							ResultSet newQueryResult = statement.executeQuery(verifyAnswer2);
							label_password_message.setText(newQueryResult.getString(verifyAnswer2));
							
					
					// if not, print error message	
					}else {
						
						label_password_message.setText("Invalid answer. Please try again");
					}	
				
					}
				}catch (Exception e) {
					e.printStackTrace();
					e.getCause();
				}
			}
		
		
		
		
		
		
	}
