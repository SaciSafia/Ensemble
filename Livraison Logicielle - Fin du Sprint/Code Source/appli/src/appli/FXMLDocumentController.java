/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * FXML Controller class
 *
 * @author natha
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane jjj;
    @FXML
    private Label userName;
    @FXML
    private TextField userNametxt;
    @FXML
    private Button lgn;
    @FXML
    private TextField passwordtxt;
    @FXML
    private Label password;
    @FXML
    private Label errortxt;
    
    
               
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    }

    @FXML
    private void loginOkClicked(ActionEvent event) throws InterruptedException, IOException, SQLException, ClassNotFoundException {
        Stage appStage;
        Parent root;  
        if(userNametxt.getText().isEmpty() || passwordtxt.getText().isEmpty())
        {
            errortxt.setText("Login and/or password field are required");
        }
        else
        {
            String BDD = "pasteur";
            String url = "jdbc:mysql://localhost:3306/" + BDD;
            String user = "root";
            String passwd = "";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            
            String id = userNametxt.getText();
            String mp = passwordtxt.getText();
            
            Statement state = conn.createStatement();
                        
            ResultSet result = state.executeQuery("SELECT mp FROM `personnel` WHERE id = '"+ id+ "'");

            ResultSetMetaData resultMeta = result.getMetaData();

           String motDePasse = "";

            while (result.next()) {
               motDePasse = result.getString(1);
            }

            if(motDePasse.equals(mp))
            {
                errortxt.setText("authentification réussie,    wait...");
                sleep(1000);

                appStage=(Stage)lgn.getScene().getWindow();
                root=FXMLLoader.load(getClass().getResource("honeScene.fxml"));
                Scene scene=new Scene(root);
                appStage.setScene(scene);
                appStage.show();
            }
            else
            {
                errortxt.setText("Le mot de passe est faux");
            }

            result.close();
            state.close();
        }
    }  
}