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
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

 

public class SearchController implements Initializable {
	
	
	@FXML
	private TableView<FlightModel> table;
	@FXML
	private TableColumn<FlightModel, Integer> idColumn;
	@FXML
	private TableColumn<FlightModel, String> toCityColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveDateColumn;
	@FXML
	private TableColumn<FlightModel, String> arriveTimeColumn;
	@FXML
	private TableColumn<FlightModel, String> departDateColumn;
	@FXML
	private TableColumn<FlightModel, String> departTimeColumn;

	private TextField arriveText;  
	private TextField departText;
	private TextField fromText;
	private TextField toText;
	
	//private Button searchButton;
	private Button button_logout;
	@FXML
	private Button button_account;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	ObservableList <FlightModel> flightModelObservableList = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
			
		
		try {
			Connection connection = DriverManager.getConnection
					("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
			String displayFlights = "SELECT flightid, tocity, arrivedate, arrivetime, departdate, departtime FROM FINALFLIGHTS2"; 
		
			Statement statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery(displayFlights);
		
			idColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, Integer>("flightid"));
			toCityColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("tocity"));
			arriveDateColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("arrivedate"));
			arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("arrivetime"));
			departDateColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("departdate"));
			departTimeColumn.setCellValueFactory(new PropertyValueFactory<FlightModel, String>("departtime"));
		
			while (queryResult.next()) {
			
				Integer queryFlightid = queryResult.getInt("flightid");
				String queryToCity = queryResult.getString("tocity");
				String queryArriveDate = queryResult.getString("arrivedate");
				String queryArriveTime = queryResult.getString("arrivetime");
				String queryDepartDate = queryResult.getString("departdate");
				String queryDepartTime = queryResult.getString("departtime");

				flightModelObservableList.add(new FlightModel(queryFlightid, queryToCity, queryArriveDate, queryArriveTime, queryDepartDate, queryDepartTime));
			}
			
			
			table.setItems(flightModelObservableList);
			
		
		} catch (SQLException e){
			System.out.print("Hi");
			
			Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	/*	FilteredList<FlightModel> filteredData = new FilteredList<>(flightModelObservableList, b -> true);
			
			//start 
			arriveText.textProperty().addListener((observable, aldValue, newValue) -> {
				filteredData.setPredicate(productSearchModel -> {
					
					if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
					return true;
					}
					
					String searchKeyboard = newValue.toLowerCase();
					
					if (FlightModel.getArriveDate().toLowerCase().indexOf(searchKeyboard) > -1) {
						
					} else 
						return false;
				});
			});
			// end
			
			departText.textProperty().addListener((observable, aldValue, newValue) -> {
				filteredData.setPredicate(productSearchModel -> {
					
					if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
						return true;
					}
					
					String searchKeyboard = newValue.toLowerCase();
					
					if (FlightModel.getDepartDate().toLowerCase().indexOf(searchKeyboard) > -1) {
						
					} else 
						return false;
				});
			});
			
			SortedList<FlightModel> sortedData = SortedList<>(filteredData);
			
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			
			table.setItems(sortedData);
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
