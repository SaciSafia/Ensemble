/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safia
 */
public class VaccinedPatientSceneController implements Initializable {

    @FXML
    private Button addPatient;
    @FXML
    private Button homebtn1;
    @FXML
    private Button searchPatient;
    private Label patientFound;
    @FXML
    private Label patientnotFound;
    @FXML
    private TextField idPateint;
    @FXML
    private Label patientFoundid;
    @FXML
    private Label patientFoundnom;
    @FXML
    private Label patientFound2;
    @FXML
    private Label patientFoundprenom;
    @FXML
    private Label patientFoundNaidd;
    @FXML
    private Label patientFoundvaccin;
    @FXML
    private Label patientFounddose1;
    @FXML
    private Label patientFounddose2;
    @FXML
    private Label patientFounddose3;

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

    @FXML
    private void toHomePage1(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)homebtn1.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("honeScene.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }

    @FXML
    private void searchPatient(ActionEvent event) throws ClassNotFoundException, SQLException {
        
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            String id = idPateint.getText();
            //System.out.println(id);
          
            Statement st, st2, st3, st4, st5, st6, st7, st8;
            ResultSet rs, rs2, rs3, rs4, rs5, rs6, rs7, rs8;
            
            st = conn.createStatement();        
            String requete = "SELECT ID FROM `patients` WHERE ID = '"+ id+ "'";
            rs = st.executeQuery(requete); 
            String key = "";
            while (rs.next()) {
                key = rs.getString(1);
                System.out.println(key);
                patientFoundid.setText(key);
            }
            
            st2 = conn.createStatement();        
            String requete2 = "SELECT nom FROM `patients` WHERE ID = '"+ id+ "'";
            rs2 = st2.executeQuery(requete2); 
            String key2 = "";
            while (rs2.next()) {
                key2 = rs2.getString(1);
                System.out.println(key2);
                patientFoundnom.setText(key2);
            }
            
            st3 = conn.createStatement();        
            String requete3 = "SELECT prenom FROM `patients` WHERE ID = '"+ id+ "'";
            rs3 = st3.executeQuery(requete3); 
            String key3 = "";
            while (rs3.next()) {
                key3 = rs3.getString(1);
                System.out.println(key3);
                patientFoundprenom.setText(key3);
            }
            
            
            st4 = conn.createStatement();        
            String requete4 = "SELECT dateNaiss FROM `patients` WHERE ID = '"+ id+ "'";
            rs4 = st4.executeQuery(requete4); 
            String key4 = "";
            while (rs4.next()) {
                key4 = rs4.getString(1);
                System.out.println(key4);
                patientFoundNaidd.setText(key4);
            }
 
            st5 = conn.createStatement();        
            String requete5 = "SELECT typeVaccin FROM `patients` WHERE ID = '"+ id+ "'";
            rs5 = st5.executeQuery(requete5); 
            String key5 = "";
            while (rs5.next()) {
                key5 = rs5.getString(1);
                System.out.println(key5);
                patientFoundvaccin.setText(key5);
            }
            
            st6 = conn.createStatement();        
            String requete6 = "SELECT dateDose1 FROM `patients` WHERE ID = '"+ id+ "'";
            rs6 = st6.executeQuery(requete6); 
            String key6 = "";
            while (rs6.next()) {
                key6 = rs6.getString(1);
                System.out.println(key6);
                patientFounddose1.setText(key6);
            }
            
            st7 = conn.createStatement();        
            String requete7 = "SELECT dateDose2 FROM `patients` WHERE ID = '"+ id+ "'";
            rs7 = st7.executeQuery(requete7); 
            String key7 = "";
            while (rs7.next()) {
                key7 = rs7.getString(1);
                System.out.println(key7);
                patientFounddose2.setText(key7);
            }
            
            
            st8 = conn.createStatement();        
            String requete8 = "SELECT dateDose3 FROM `patients` WHERE ID = '"+ id+ "'";
            rs8 = st8.executeQuery(requete8); 
            String key8 = "";
            while (rs8.next()) {
                key8 = rs8.getString(1);
                System.out.println(key8);
                patientFounddose3.setText(key8);
            }

            
            
    }
    
}
