/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstone;
import magstone.login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author macbook
 */
public class Magstone extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
     
    }

    @Override
    public void start(Stage primaryStage) {
        login obj=new login();
        obj.setIconImage(new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());       
        obj.setVisible(true);
    }
    
}
