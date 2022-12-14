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
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchController implements Initializable {
	
	@FXML
	private TableView<FlightModel> table;
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
	private TextField tf_flight;  
	@FXML
	private TextField cityText;  
	@FXML
	private TextField dateText;
	
	//private Button searchButton;
	@FXML
	private Button button_logout;
	@FXML
	private Button button_account;
	@FXML
	private Label label_flight_message;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	ObservableList <FlightModel> flightModelObservableList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
		try {
			Connection connection = DriverManager.getConnection
					("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
			String displayFlights = "SELECT flightid, tocity, arrivedate, arrivetime, fromcity, departdate, departtime FROM FINALFLIGHTS2"; 
		
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
			
			table.setItems(flightModelObservableList);
			
			System.out.println("huh");
			
			FilteredList<FlightModel> filteredData = new FilteredList<>(flightModelObservableList, b -> true);
			
			cityText.textProperty().addListener((observable, oldValue, newValue) -> {
				
				filteredData.setPredicate(FlightModel -> {
					
					if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
						return true;
					}
					
					String search = newValue.toLowerCase();
					
					if(FlightModel.getTocity().toLowerCase().indexOf(search) > -1) {
						return true;
					} else if(FlightModel.getFromcity().toLowerCase().indexOf(search) > -1) {
						return true;
					} else
						return false;	
				});
			});
			
			dateText.textProperty().addListener((observable, oldValue, newValue) -> {
				
				filteredData.setPredicate(FlightModel -> {
					
					if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
						return true;
					}
					
					String search1 = newValue.toLowerCase();
					
					if(FlightModel.getArrivedate().toLowerCase().indexOf(search1) > -1) {
						return true;
					} else if(FlightModel.getDepartdate().toLowerCase().indexOf(search1) > -1) {
						return true;
					} else
						return false;	
				});
			});
			
			SortedList<FlightModel> sortData = new SortedList<>(filteredData);
			
			sortData.comparatorProperty().bind(table.comparatorProperty());
			
			table.setItems(sortData);
		
		} catch (SQLException e){
		System.out.print("Hi");	
		Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, e);
		e.printStackTrace();
		}
	}
		
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
	
	public void goToAdmin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../gui/Admin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void add(ActionEvent event) throws IOException, SQLException {
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		
		String flight = tf_flight.getText();
		//create string (verifyLogin) that will compare user input to database attributes
		String  repeat = "SELECT COUNT(1) FROM " + User.user + " WHERE flightid = " + flight + "";	
		try {
			Statement statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery(repeat);
						
			//turn queryResult into int and test if its 1 (if theres a match), if so go to search page
			while (queryResult.next()) {
				if (queryResult.getInt(1)==1) {
					//how do i specify what table to insert flight values in if its based on textfield in regiter controller
				label_flight_message.setText("Flight already exists.");
					//set label message
					

				} else {
					String insert = "INSERT INTO " + User.user + " SELECT * FROM [dbo].[FINALFLIGHTS2] WHERE flightid = " + flight + "";
					Statement st = connection.createStatement();
					st.executeUpdate(insert);
					
					label_flight_message.setText("Flight added!");
				}
			}
		}
				
				catch (Exception e) {
					e.printStackTrace();
					e.getCause();
				}
		
				}
			
					//set label
	}
			
