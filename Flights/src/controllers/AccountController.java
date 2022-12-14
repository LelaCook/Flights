package controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AccountController implements Initializable {
	
	@FXML
	private TableView<FlightModel> account;
	@FXML
	private TableColumn<FlightModel, String> idColumn;
	@FXML
	private TableColumn<FlightModel, String> toCityColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveDateColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveTimeColumn;
	@FXML
	private TableColumn<FlightModel, String> fromCityColumn;
	@FXML
	private TableColumn<FlightModel, String> departDateColumn;
	@FXML
	private TableColumn<FlightModel, String> departTimeColumn;
	
	@FXML 
	private Button button_back;
	private Button button_logout;
	private Button deleteButton;
	private Button button_refresh;
	@FXML
	private TextField IdText;
	@FXML
	private Label label_message;
	//private TableView yourFlight;
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	ObservableList <FlightModel> flightModelObservableList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
		try {
			Connection connection = DriverManager.getConnection
					("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
			String displayFlights = "SELECT flightid, tocity, arrivedate, arrivetime, fromcity, departdate, departtime FROM " + User.user; 
		
			Statement statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery(displayFlights);
		
			while (queryResult.next()) {
			
				String queryFlightid = queryResult.getString("flightid");
				String queryToCity = queryResult.getString("tocity");
				String queryArriveDate = queryResult.getString("arrivedate");
				String queryArriveTime = queryResult.getString("arrivetime");
				String queryFromCity = queryResult.getString("fromcity");
				String queryDepartDate = queryResult.getString("departdate");
				String queryDepartTime = queryResult.getString("departtime");
				
			flightModelObservableList.add(new FlightModel(queryFlightid,queryToCity, queryArriveDate, queryArriveTime, queryFromCity, queryDepartDate, queryDepartTime));
			
			}
			
			idColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("flightid"));
			toCityColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("tocity"));
			arriveDateColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("arrivedate"));
			arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("arrivetime"));
			fromCityColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("fromcity"));
			departDateColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("departdate"));
			departTimeColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("departtime"));
			
			account.setItems(flightModelObservableList);
			
			System.out.println("what");
			
		} catch (SQLException e){
			System.out.print("Hi");
			
			Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			
		}
	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Searches.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void logout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void refresh(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../gui/Account.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void delete(ActionEvent event) throws IOException, SQLException {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		String remove = IdText.getText();

		String  verifyidinput = "SELECT COUNT(1) FROM " + User.user + " WHERE flightid = " + remove + "";	
		try {	
			Statement sta = connection.createStatement();
			ResultSet queryResult = sta.executeQuery(verifyidinput);
			
			//turn queryResult into int and test if its 1 (if theres a match), if so go to search page
			while (queryResult.next()) {
				if (queryResult.getInt(1)==1) {
		
			//need to reference specific user table;
					String b = "DELETE FROM " + User.user + " WHERE flightid = " + remove ;
					Statement statement = connection.createStatement();
		
					statement.executeUpdate(b); 
			
					System.out.println("Deleted");
					label_message.setText("Flight Deleted! Please refresh.");
				}else {
					label_message.setText("Flight doesnt exist");	
					}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause(); }
	}

	
}
	