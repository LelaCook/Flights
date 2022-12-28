package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import application.Flight;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchController implements Initializable {
	
	@FXML
	private TableView<FlightModel> table;
	@FXML
	private TableColumn<FlightModel, Integer> idColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveDateColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveTimeColumn;
	@FXML
	private TableColumn<FlightModel, String> departDateColumn;
	@FXML
	private TableColumn<FlightModel, String> departTimeColumn;
	@FXML
	
	
	//private Button searchButton;
	private Button button_logout;
	@FXML
	private Button button_account;
	//private Button addButton;
	//private TableColumn<Flight, String> arriveColumn;
	//private TableColumn<Flight, String> departColumn;
	//private TableColumn<Flight, Integer> idColumn;
	//private TableColumn<Flight, Date> landingColumn;
	//private TableColumn<Flight, Date> takeOffColumn;
	//private TableView<?> table;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	ObservableList <FlightModel> flightModelObservableList = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		String displayFlights = "SELECT flightid, arrivedate, arrivetime, departdate, departtime FROM FINALFLIGHTS"; 
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery(displayFlights);
		
			while (queryResult.next()) {
				Integer queryFlightid = queryResult.getInt("flightid");
				String queryArriveDate = queryResult.getString("arrivedate");
				String queryArriveTime = queryResult.getString("arrivetime");
				String queryDepartDate = queryResult.getString("departdate");
				String queryDepartTime = queryResult.getString("departtime");

				
				
				flightModelObservableList.add(new FlightModel(queryFlightid,queryArriveDate,queryArriveTime,queryDepartDate,queryDepartTime));
			}
			
			
					
		
		
		}catch {
	}
	
	
	//ObservableList<Flight> listM;
	
	//int index = -1;
	
	//Connection conn = null;
	//ResultSet rs = null;
	//PreparedStatement pst = null;
	
	/*
	@Override
	public void initialize(URL url, ResourceBundle rd) {
		
		arriveColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrive"));
		departColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("depart"));
		idColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("id"));
		landingColumn.setCellValueFactory(new PropertyValueFactory<Flight, Date>("landing"));
		takeOffColumn.setCellValueFactory(new PropertyValueFactory<Flight, Date>("take off"));
		
		listM = mysqlconnect.getDataFlight();
		table.setItems(listM);
		
	}
	*/
	
	public void logout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Logout.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goToAccount(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Account.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void add(ActionEvent event) throws IOException, SQLException {
		//type in flight ID, insert flight ID into userAccounts
		//for account controller, IF flightID (flighttable) == flightID (userAccounts) , write select statement to display flight info based on flight ID from flight table 
	}
	
	
	public void search(ActionEvent event) throws IOException, SQLException {
		
		
		
	}

	
	
}
