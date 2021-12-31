package application.controller;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import application.model.Classifieds;
import javafx.event.ActionEvent;

public class ClassifiedsController {

    @FXML
    private AnchorPane classifiedsPane;

    @FXML
    private Button homeButton;

    @FXML
    private Label topLeftJob;

    @FXML
    private Label topLeftDetails;

    @FXML
    private Label topLeftPoster;

    @FXML
    private Label bottomLeftJob;

    @FXML
    private Label bottomLeftDetails;

    @FXML
    private Label bottomLeftPoster;

    @FXML
    private Label topRightJob;

    @FXML
    private Label topRightDetails;

    @FXML
    private Label topRightPoster;

    @FXML
    private Label bottomRightJob;

    @FXML
    private Label bottomRightDetails;

    @FXML
    private Label bottomRightPoster;


    public void initialize(){
        setClassifiedsText();
    }

    //needs to load info into Labels, and handle screen change for button
    public void handleHome(ActionEvent event) throws IOException{
        classifiedsPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../Main.fxml")));
        Scene scene = new Scene(classifiedsPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    //hopefully sets text at the top left to the first advertisement's field
    public void setClassifiedsText(){
        try {
            Classifieds cl = new Classifieds(0);
            cl.loadAds("src/application/ads.csv");
            topLeftJob.setText(cl.ads.get(0).field);
            topLeftDetails.setText(cl.ads.get(0).isFullTime + "\n" + cl.ads.get(0).phoneNumber);
            topLeftPoster.setText("Posted by " + cl.ads.get(0).posterName + ", " + cl.ads.get(0).datePosted);
            bottomLeftJob.setText(cl.ads.get(1).field);
            bottomLeftDetails.setText(cl.ads.get(1).isFullTime + "\n" + cl.ads.get(1).phoneNumber);
            bottomLeftPoster.setText("Posted by " + cl.ads.get(1).posterName + ", " + cl.ads.get(1).datePosted);
            topRightJob.setText(cl.ads.get(2).field);
            topRightDetails.setText(cl.ads.get(2).isFullTime + "\n" + cl.ads.get(2).phoneNumber);
            topRightPoster.setText("Posted by " + cl.ads.get(2).posterName + ", " + cl.ads.get(2).datePosted);
            bottomRightJob.setText(cl.ads.get(3).field);
            bottomRightDetails.setText(cl.ads.get(3).isFullTime + "\n" + cl.ads.get(3).phoneNumber);
            bottomRightPoster.setText("Posted by " + cl.ads.get(3).posterName + ", " + cl.ads.get(3).datePosted);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}