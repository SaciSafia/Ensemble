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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.getString;


/**
 * FXML Controller class
 *
 * @author Safia
 */
public class MaskSceneController implements Initializable {

    @FXML
    private Button testPage;
    @FXML
    private Button homePage;
    @FXML
    private Button addMaskbtn;
    @FXML
    private Button subMaskbtn;
    @FXML
    private TextField typeMaskAdd;
    @FXML
    private TextField typeMaskSub;
    @FXML
    private TextField qttMaskAdd;
    @FXML
    private TextField qttMasksub;
    @FXML
    private Button vaccinePage;
    @FXML
    private Label nbffp2;
    @FXML
    private Button stk1;
    @FXML
    private Button stk2;
    @FXML
    private Label nbrffp2_;
    @FXML
    private Label nbrchir_;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
        @FXML
    private void addMask(ActionEvent event) throws ClassNotFoundException, SQLException {
            
  
        int valeur = Integer.parseInt(qttMaskAdd.getText());
        String type = typeMaskAdd.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            Statement state = conn.createStatement();
                       
            ResultSet result = state.executeQuery("SELECT quantite FROM typemasques WHERE type='"+type+"'");
            
            int valeurAvant;
            String inter = null;

            while (result.next()) {
               inter = result.getString(1);
            }

            valeurAvant = Integer.valueOf(inter);

            int valeurNouvelle = valeurAvant + valeur;


            Statement state2 = conn.createStatement();

            state2.executeUpdate("UPDATE typemasques SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttMaskAdd.setText("");
            typeMaskAdd.setText("");
            
            
        }
     
                    
    }

    @FXML
    private void subMask(ActionEvent event) throws ClassNotFoundException, SQLException{
        
        
       int valeur = Integer.parseInt(qttMasksub.getText());
        String type = typeMaskSub.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();
             
            
            ResultSet result = state.executeQuery("SELECT quantite FROM typemasques WHERE type='"+type+"'");
            
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

            state2.executeUpdate("UPDATE typemasques SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttMasksub.setText("");
            typeMaskSub.setText("");
            
        }
        
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
    private void toVaccinePage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)vaccinePage.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("VaccineScene.fxml"));
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
            
            String requete = "SELECT quantite FROM typemasques where type = 'FFP2'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);

                nbrffp2_.setText(key);
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
            
            String requete = "SELECT quantite FROM typemasques where type = 'Chirurgicals'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);
                nbrchir_.setText(key);
            }
    }

    
}