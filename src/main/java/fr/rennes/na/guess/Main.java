package fr.rennes.na.guess;

import fr.rennes.na.guess.model.entity.Item;
import fr.rennes.na.guess.model.service.CardService;
import fr.rennes.na.guess.model.service.CardServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by herrard on 27/03/15.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader=new FXMLLoader();
        Parent root = loader.load(getClass().getClassLoader().getResource("start.fxml"));

        CardService service=new CardServiceImpl();


        service.addItemToCat("Hello","Common",2);
        service.addItemToCat("Bye","Common");
        service.addItemToCat("Benz","Brand",1);

        List<Item> items=service.getItems("Common",0,1);
        for(Item i:items){
            System.out.println(i.getContent());
        }
        primaryStage.setTitle("Let's Guess");
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);


        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
