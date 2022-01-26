/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safia
 */
public class HoneSceneController implements Initializable {
    private Button btn;
    
    private Button btnMask;
    @FXML
    private Button mask;
    @FXML
    private Button Vaccine;
    @FXML
    private Button tests;
    @FXML
    private Button listPatient;
    @FXML
    private Button form;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void toMaskWindow(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)mask.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("MaskScene.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void toVaccineWindow(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)Vaccine.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("VaccineScene.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void toTestWindow(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)tests.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("TestScene.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
        
    }

    @FXML
    private void toListVaccinedPatient(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)listPatient.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("ListVaccined.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    private void toFormVaccinedPatient(ActionEvent event) throws IOException {
        Stage appStage;
        Parent root; 
        appStage=(Stage)form.getScene().getWindow();
        root=FXMLLoader.load(getClass().getResource("FormAddPatient.fxml"));
        Scene scene=new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }


    
}