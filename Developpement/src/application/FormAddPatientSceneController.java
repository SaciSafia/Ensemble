package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;

import javafx.scene.control.MenuButton;

public class FormAddPatientSceneController {
	@FXML
	private MenuItem maskItem;
	@FXML
	private MenuItem vaccineItem;
	@FXML
	private MenuItem testsItem;
	@FXML
	private MenuItem vaccinedItemPatient;
	@FXML
	private MenuItem addnewPatientItem;
	@FXML
	private TextField fist_name;
	@FXML
	private TextField last_name;
	@FXML
	private TextField date_of_birth;
	@FXML
	private TextField social_number;
	@FXML
	private MenuButton number_of_dose;
	@FXML
	private MenuButton type_of_vaccine;
	@FXML
	private Button add_patient;

	// Event Listener on MenuItem[#maskItem].onAction
	@FXML
	public void maskWindox(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#vaccineItem].onAction
	@FXML
	public void vaccineWindow(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#testsItem].onAction
	@FXML
	public void testsWindows(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#vaccinedItemPatient].onAction
	@FXML
	public void vaccinedPatientWindow(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on MenuItem[#addnewPatientItem].onAction
	@FXML
	public void addNewPatientWindow(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#add_patient].onAction
	@FXML
	public void addPatient(ActionEvent event) {
		// TODO Autogenerated
	}
}
