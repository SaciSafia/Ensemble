/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class FormAddPatientSceneController implements Initializable {

    @FXML
    private TextField fist_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField date_of_birth;
    @FXML
    private TextField social_number;
    @FXML
    private Button add_patient;
    @FXML
    private Button listPatient;
    @FXML
    private Button homebtn;
    @FXML
    private TextField nbrDose;
    @FXML
    private TextField typeDose;
    @FXML
    private TextField Dose1;
    @FXML
    private TextField Dose2;
    @FXML
    private TextField Dose3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPatient(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException {
      
        
        String BDD = "pasteur";
        String url = "jdbc:mysql://localhost:3306/" + BDD;
        String user = "root";
        String passwd = "";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, passwd);
        
        
        String nom = fist_name.getText();
        String prenom = last_name.getText();
        String dateNaiss = date_of_birth.getText();
        String dateVac1 = Dose1.getText();
        String dateVac2 = Dose2.getText();
        String dateVac3 = Dose3.getText();    
        String typeVaccin = typeDose.getText();
        
     
        
       
        fist_name.setText("");
        last_name.setText("");
        date_of_birth.setText("");
        social_number.setText("");
        Dose1.setText("");
        Dose2.setText("");
        Dose3.setText("");    
        typeDose.setText("");



        Statement state = conn.createStatement();
        state.executeUpdate("INSERT INTO `patients` (`nom`, `prenom`, `dateNaiss`, `dateDose1`, `DateDose2`, `DateDose3`, `typeVaccin`) VALUES ('"+nom+ "', '"+prenom+ "', '"+dateNaiss+ "', '"+dateVac1+ "', '"+dateVac2+ "', '"+dateVac3+ "', '"+typeVaccin +"')");
        
        state.close();
    }


    @FXML
    private void toListPatients(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)listPatient.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("ListVaccined.fxml"));
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
