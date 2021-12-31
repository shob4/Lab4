package application.controller;

import java.io.IOException;
import java.util.Objects;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView backgroundPicture;

    @FXML
    private ImageView buglePicture;

    @FXML
    private Button classifiedsButton;

    @FXML
    private Button crosswordButton;

    public void handleClassifieds(ActionEvent event) throws IOException{
        mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../Something.fxml")));// pane you are GOING TO
        Scene scene = new Scene(mainPane);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    public void handleCrossword(ActionEvent event) throws IOException{
        mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../Crossword.fxml")));
        Scene scene = new Scene(mainPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        //needs functionality;
    }

}