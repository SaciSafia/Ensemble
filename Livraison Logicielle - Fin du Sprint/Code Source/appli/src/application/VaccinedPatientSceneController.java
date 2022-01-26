/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safia
 */
public class VaccinedPatientSceneController implements Initializable {

    @FXML
    private TableColumn<?, ?> fistNamePatient;
    @FXML
    private TableColumn<?, ?> lastNamePatient;
    @FXML
    private TableColumn<?, ?> nbrSecuPatient;
    @FXML
    private TableColumn<?, ?> DateBirthPatient;
    @FXML
    private TableColumn<?, ?> typeVaccinePatient;
    @FXML
    private TableColumn<?, ?> dateDose1;
    @FXML
    private TableColumn<?, ?> dateDose2;
    @FXML
    private TableColumn<?, ?> dateDose3;
    @FXML
    private Button addPatient;
    private Button homebtn;
    @FXML
    private Button homebtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toAddNewPatient(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)addPatient.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("FormAddPatient.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    private void toHomePage(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)homebtn.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("honeScene.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void toHomePage1(ActionEvent event) {
    }
    
}
