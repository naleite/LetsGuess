package fr.rennes.na.guess.controller;

import fr.rennes.na.guess.model.entity.Item;
import fr.rennes.na.guess.model.service.CardService;
import fr.rennes.na.guess.model.service.CardServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.*;

/**
 * Created by herrard on 27/03/15.
 */
public class CardController implements Initializable {

    @FXML
    private StackPane stkpaneCard;

    @FXML
    private Button btnYes;

    @FXML
    private Button btnSkip;

    @FXML
    private ProgressBar progressTime;

    @FXML
    private Label labelInfo;

    CardService service=new CardServiceImpl();

    private Label labWord=new Label();

    private List<Item> wordsCandidator=new ArrayList<>();

    private List<Item> wordsPassed=new ArrayList<>();

    private int score=0;


    private Timer timer=new Timer();

    private double totalTime=60;
    private double gameTime=totalTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stkpaneCard.setVisible(true);

        service.addItemToCat("Hello", "Common", 2);
        service.addItemToCat("Bye","Common");
        service.addItemToCat("Benz","Brand",1);
        wordsCandidator=service.getItems("Common",0,1);



        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(gameTime>0){
                    progressTime.setProgress(gameTime--/totalTime);

                }
                else timer.cancel();

            }
        },0,1000);

        stkpaneCard.getChildren().add(labWord);

        updateView();

    }

    private void updateView(){
        labWord.setText(wordsCandidator.get(0).getContent());
        labelInfo.setText(score+"");
    }
}
