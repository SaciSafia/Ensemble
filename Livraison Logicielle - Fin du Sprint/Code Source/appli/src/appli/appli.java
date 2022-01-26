/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;


import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author natha
 */
public class appli extends Application  {
    
    private Stage window;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        window.setTitle("main");
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    private void sceneHandler() throws IOException{
        System.out.println("Scene changing...");
        root = FXMLLoader.load(getClass().getResource("honeScene.fxml"));
        window.setScene(new Scene(root));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        launch(args);
    }
    
}