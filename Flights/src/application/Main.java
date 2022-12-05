package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Label;
import javafx.scene.TextField;
import javafx.scene.GridPane;

public class Main extends Application {
	
	Stage window;
	Scene slash, main, login, register, forgot, open, list, admin, search; 
	Button toLog, toRes, toFor, log, logout;
	GridPane grid;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Flights R Us");
		
		// Travel buttons
		toLog = new Button ();
		toLog.setText("Login");
		toLog.setOnAction(e -> window.setScene(login));
		
		toRes = new Button ();
		toRes.setText("Register");
		toRes.setOnAction(e -> window.setScene(register));
		
		toFor = new Button ();
		toFor.setText("Forgot Password");
		toFor.setOnAction(e -> Forgot.display("Forgot Password"));
		
		// Scenes Set up
		// Main
		StackPane layout = new StackPane();
		layout.getChildren().addAll(toLog, toRes);
		
		Scene main = new Scene(layout, 300, 250);
		
		// Login
		GridPane grid = GridPane();
		grid.setPadding(new Inserts(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label username = new Label("Username: ");
		GridPane.setConstraints(username, 0, 0);
		Label password = new Label("Password: ");
		GridPane.setConstraints(password, 0, 1);
		
		TextField usern = new TextField("Username");
		GridPane.setConstraints(usern, 1, 0);
		TextField passw = new TextField("Password");
		GridPane.setConstraints(passw, 1, 1);
		
		Button log = new Button("Log In");
		GridPane.setConstraints(passw, 0, 2);
		GridPane.setConstraints(toFor, 1, 2);
		
		grid.getChildren().addAll(username, password, usern, passw, log, toFor);
		
		Scene login = new Scene(grid, 300, 250);
		
	}
}
