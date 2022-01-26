/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safia
 */
public class appliFormAddPatientSceneController implements Initializable {

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
    @FXML
    private Button listPatient;
    @FXML
    private Button homebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPatient(ActionEvent event) {
    }

    @FXML
    private void toListPatients(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)listPatient.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource(".fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }

    @FXML
    private void toHomePage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)homebtn.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("honeScene.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }
    
}
