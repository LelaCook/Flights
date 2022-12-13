package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
		primaryStage.setTitle("Opening");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
		
	}
	
	
}