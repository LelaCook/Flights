package gui;

import javafx.scene.control.Button;

public class SplashController {
	
	public Button button; 
	
	public void clicked() {
		System.out.print("Clicked");;
		button.setText("clicked");
	}

}
