package controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AdminController {
	
	@FXML
	private Button addButton;
	private Button deleteButton;
	private TextField flightId;
	private TextField capacity;
	private TextField cityFrom;
	private TextField cityto;
	private TextField idToDelete;
	private DatePicker depart;
	private DatePicker arrive;
	
	public void add (ActionEvent event) throws IOException, SQLException  {
		
	}
	
	public void delete (ActionEvent event) throws IOException, SQLException {
		
	}

}
