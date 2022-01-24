/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitements;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author natha
 */
public class Traitements {
    static Connection conn;
    static Statement state;
    static ResultSet result;
    static ResultSetMetaData resultMeta;
    static Object[][] donn;
    static String[] champs;
    static Object[] val;
    /** 
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException
    {
       String BDD = "pasteur";
                String url = "jdbc:mysql://localhost:3306/" + BDD;
                String user = "root";
                String passwd = "";
                   
                     
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecté à la BDD");
                    System.out.println("Faites un choix :");
                    System.out.println("1 - S'authentifier");
                    System.out.println("2 - Affichage de la population");
                    System.out.println("3 - Création patient");
                    System.out.println("4 - Ajout masques");
                    System.out.println("5 - Suppression masques");
                    System.out.println("6 - Ajout tests");
                    System.out.println("7 - Suppression tests");
                    System.out.println("8 - Ajout vaccins");
                    System.out.println("9 - Suppression vaccins");
                    
                    int choix;
                    
                    Scanner in = new Scanner(System.in);
                    
                    choix = in.nextInt();
                                        
                    
                    
                    if(choix == 1)
                    {
                        System.out.println("Rentrez votre id");
                               
                        int id = in.nextInt();
                        
                        
                        System.out.println("Rentrez le mot de passe:");
                               
                        String saisie = in.next();
                        
                     
                        
                        
                        Statement state = conn.createStatement();
                        
                        ResultSet result = state.executeQuery("SELECT mp FROM `personnel` WHERE id = '"+ id+ "'");
                        
                        ResultSetMetaData resultMeta = result.getMetaData();

                       String motDePasse = "";
                        
                        while (result.next()) {
                           motDePasse = result.getString(1);
                        }
                        
                        if(motDePasse.equals(saisie))
                        {
                            System.out.println("mp juste");
                        }
                        else
                        {
                            System.out.println("mp faux");
                        }
                            
                          
                            
                        result.close();
                        state.close();
                        
                    }
                    else if (choix == 2)
                    {
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT * FROM patients");
                   
                        ResultSetMetaData resultMeta = result.getMetaData();

                       
                                            
                   
                        while(result.next()){
                           for(int i = 1; i < resultMeta.getColumnCount(); i++)
                           System.out.print("      " + result.getObject(i).toString() + "      ");   
                           System.out.println(""); 
                        }

                        // On ferme tout les connexion à la base de données
                        result.close();
                        state.close();
                    }
                    
                    else if (choix == 3)
                    {
                        String nom = "test";
                        String prenom="test";
                        String dateNaiss="10/1/22";
                        String dateVac1="10/1/22";
                        String dateVac2="10/1/22";
                        String dateVac3="10/1/22";    
                        String typeVaccin="test";
                        
                        
                        
                        
                        
                        Statement state = conn.createStatement();
                        state.executeUpdate("INSERT INTO `patients` (`nom`, `prenom`, `dateNaiss`, `dateDose1`, `DateDose2`, `DateDose3`, `typeVaccin`) VALUES ('"+nom+ "', '"+prenom+ "', '"+dateNaiss+ "', '"+dateVac1+ "', '"+dateVac2+ "', '"+dateVac3+ "', '"+typeVaccin +"')");
                         result.close();
                        state.close();
                        
                    }
                    
                    
                    
                    else if (choix == 4)
                    {
                        String type = "test";
                                             
                        System.out.println("On en ajoute combien?");
                        
                        int ajout = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM typemasques WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant + ajout;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE typemasques SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    
                    else if (choix == 5)
                    {
                        String type = "test";
                                             
                        System.out.println("On en supprime combien?");
                        
                        int suppr = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM typemasques WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant - suppr;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE typemasques SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    
                    
                    else if (choix == 6)
                    {
                        String type = "test";
                                             
                        System.out.println("On en ajoute combien?");
                        
                        int ajout = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM tests WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant + ajout;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE tests SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    
                    else if (choix == 7)
                    {
                        String type = "test";
                                             
                        System.out.println("On en supprime combien?");
                        
                        int suppr = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM tests WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant - suppr;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE tests SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    else if (choix == 8)
                    {
                        String type = "test";
                                             
                        System.out.println("On en ajoute combien?");
                        
                        int ajout = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM vaccins WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant + ajout;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE vaccins SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    
                    else if (choix == 9)
                    {
                        String type = "test";
                                             
                        System.out.println("On en supprime combien?");
                        
                        int suppr = in.nextInt();
                        
                        
                        
                        Statement state = conn.createStatement();
                       
                        ResultSet result = state.executeQuery("SELECT quantite FROM vaccins WHERE type='"+type+"'");
                        
                        
                        int valeurAvant;
                        String inter = null;
                        
                        while (result.next()) {
                           inter = result.getString(1);
                        }
                        
                        valeurAvant = Integer.valueOf(inter);
                        
                        int valeurNouvelle = valeurAvant - suppr;
                        
                        
                        Statement state2 = conn.createStatement();
                       
                        state2.executeUpdate("UPDATE vaccins SET quantite = '"+valeurNouvelle+"' WHERE type = '"+type+"'");
                        
                        
                    }
                    
                       
                }
                
                catch (SQLException e) {
                            
                   
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
                
                
                
                
    }
    
   
    
}
