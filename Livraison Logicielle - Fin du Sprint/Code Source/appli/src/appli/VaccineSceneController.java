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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Safia
 */
public class VaccineSceneController implements Initializable {

    @FXML
    private Button addVaccinebtn;
    @FXML
    private Button subVaccinebtn;
    @FXML
    private TextField typeVaccineAdd;
    @FXML
    private TextField typevaccineSub;
    @FXML
    private TextField qttVaccineAdd;
    @FXML
    private TextField qttViccinesub;
    @FXML
    private Button masksPage;
    @FXML
    private Button testPage;
    @FXML
    private Button homePage;
    @FXML
    private Button stk1;
    @FXML
    private Button stk2;
    @FXML
    private Button stk3;
    @FXML
    private Label nbmoderna;
    @FXML
    private Label nbpfizer;
    @FXML
    private Label nbAstrazeneca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addVaccine(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        int valeur = Integer.parseInt(qttVaccineAdd.getText());
        String type = typeVaccineAdd.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            Statement state = conn.createStatement();
                       
            ResultSet result = state.executeQuery("SELECT quantite FROM vaccins WHERE type='"+type+"'");
            
            int valeurAvant;
            String inter = null;

            while (result.next()) {
               inter = result.getString(1);
            }

            valeurAvant = Integer.valueOf(inter);

            int valeurNouvelle = valeurAvant + valeur;


            Statement state2 = conn.createStatement();

            state2.executeUpdate("UPDATE vaccins SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttVaccineAdd.setText("");
            typeVaccineAdd.setText("");
        }
    }

    @FXML
    private void subVaccine(ActionEvent event) throws ClassNotFoundException, SQLException {
        
         
        
        int valeur = Integer.parseInt(qttViccinesub.getText());
        String type = typevaccineSub.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            Statement state = conn.createStatement();
                       
            ResultSet result = state.executeQuery("SELECT quantite FROM vaccins WHERE type='"+type+"'");
            
            int valeurAvant;
            String inter = null;

            while (result.next()) {
               inter = result.getString(1);
            }

            valeurAvant = Integer.valueOf(inter);
            
            int valeurNouvelle;
            
            if(valeur > valeurAvant)
            {
                valeurNouvelle =0;
            }
            else
            {
                valeurNouvelle = valeurAvant - valeur;
            }
            


            Statement state2 = conn.createStatement();

            state2.executeUpdate("UPDATE vaccins SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttViccinesub.setText("");
            typevaccineSub.setText("");
            
        }
        
        
        
    }

    
    
    
    @FXML
    private void toMaskPage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)masksPage.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("MaskScene.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }

    @FXML
    private void toTestPage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)testPage.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("TestScene.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }

    @FXML
    private void toHomePage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)homePage.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("honeScene.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
    }

    @FXML
    private void ShowStock1(ActionEvent event) throws ClassNotFoundException, SQLException {
        String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            
            String requete = "SELECT quantite FROM vaccins where type = 'Moderna'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);
                nbmoderna.setText(key);
            }
    }

    @FXML
    private void ShowStock2(ActionEvent event) throws ClassNotFoundException, SQLException {
        String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            
            String requete = "SELECT quantite FROM vaccins where type = 'Pfizer'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);
                nbpfizer.setText(key);
            }
    }

    @FXML
    private void ShowStock3(ActionEvent event) throws ClassNotFoundException, SQLException {
        String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            
            String requete = "SELECT quantite FROM vaccins where type = 'Astrazeneca'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);
                nbAstrazeneca.setText(key);
            }
    }
    
}