package fr.rennes.na.guess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by herrard on 27/03/15.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader=new FXMLLoader();
        Parent root = loader.load(getClass().getClassLoader().getResource("main.fxml"));


        primaryStage.setTitle("Let's Guess");
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);


        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
