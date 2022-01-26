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
public class TestSceneController implements Initializable {

    @FXML
    private Button addTestbtn;
    @FXML
    private Button subTestbtn;
    @FXML
    private TextField typeTestdd;
    @FXML
    private TextField typeTestSub;
    @FXML
    private TextField qttTestAdd;
    @FXML
    private TextField qttTestsub;
    @FXML
    private Button masksPage;
    @FXML
    private Button VaccinePage;
    @FXML
    private Button homePage;
    @FXML
    private Label nbTestAntigenic;
    @FXML
    private Label nbrTestPcr;
    @FXML
    private Button stkAnt;
    @FXML
    private Button stk;

    /**
     * Initializes the controller class.
     */
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            

    }    

    @FXML
    private void addTests(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        int valeur = Integer.parseInt(qttTestAdd.getText());
        String type = typeTestdd.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            Statement state = conn.createStatement();
                       
            ResultSet result = state.executeQuery("SELECT quantite FROM tests WHERE type='"+type+"'");
            
            int valeurAvant;
            String inter = null;

            while (result.next()) {
               inter = result.getString(1);
            }

            valeurAvant = Integer.valueOf(inter);

            int valeurNouvelle = valeurAvant + valeur;


            Statement state2 = conn.createStatement();

            state2.executeUpdate("UPDATE tests SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttTestAdd.setText("");
            typeTestdd.setText("");
        }
     
    }

    @FXML
    private void subTests(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        
        int valeur = Integer.parseInt(qttTestsub.getText());
        String type = typeTestSub.getText();

        if(valeur > 1)
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            Statement state = conn.createStatement();
                       
            ResultSet result = state.executeQuery("SELECT quantite FROM tests WHERE type='"+type+"'");
            
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

            state2.executeUpdate("UPDATE tests SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
            
            qttTestsub.setText("");
            typeTestSub.setText("");
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
    private void toVaccinePage(ActionEvent event) throws IOException {
            Stage appStage;
            Parent root; 
            appStage=(Stage)VaccinePage.getScene().getWindow();
            root=FXMLLoader.load(getClass().getResource("VaccineScene.fxml"));
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
    private void ShowStockAnt(ActionEvent event) throws ClassNotFoundException, SQLException {
            
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            
            String requete = "SELECT quantite FROM tests where type = 'Antigenic'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);

                nbTestAntigenic.setText(key);
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
            
            String requete = "SELECT quantite FROM tests where type = 'PCR'; ";
            rs = st.executeQuery(requete);
            while (rs.next()) {
                String key = rs.getString(1);
                System.out.println(key);

                nbrTestPcr.setText(key);
            }
    }
    
}