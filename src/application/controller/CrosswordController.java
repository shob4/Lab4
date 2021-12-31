package application.controller;

import java.io.*;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CrosswordController {

    @FXML
    private AnchorPane crosswordPane;

    @FXML
    private Button homeButton;

    @FXML
    private Label downClues;

    @FXML
    private Label acrossClues;

    @FXML
    private TextField d11a11;

    @FXML
    private TextField d71a15;

    @FXML
    private TextField a14;

    @FXML
    private TextField a13;

    @FXML
    private TextField a12;

    @FXML
    private TextField d12;

    @FXML
    private TextField d72;

    @FXML
    private TextField d73a22;

    @FXML
    private TextField d74;

    @FXML
    private TextField d75a34;

    @FXML
    private TextField a21;

    @FXML
    private TextField a23;

    @FXML
    private TextField a35;

    @FXML
    private TextField a36;

    @FXML
    private TextField d81a37;

    @FXML
    private TextField a33;

    @FXML
    private TextField d61a32;

    @FXML
    private TextField d52a31;

    @FXML
    private TextField d53a43;

    @FXML
    private TextField d62a44;

    @FXML
    private TextField d51;

    @FXML
    private TextField a42;

    @FXML
    private TextField a41;

    private ArrayList<TextField> a4 = new ArrayList<>();

    private ArrayList<TextField> a1 = new ArrayList<>();

    private ArrayList<TextField> a2 = new ArrayList<>();

    private ArrayList<TextField> a3 = new ArrayList<>();

    private ArrayList<TextField> d1 = new ArrayList<>();

    private ArrayList<TextField> d5 = new ArrayList<>();

    private ArrayList<TextField> d7 = new ArrayList<>();

    private ArrayList<String> acrossAnswers = new ArrayList<>();
    private ArrayList<String> downAnswers = new ArrayList<>();

    public void initialize(){
        setCrosswordClues();
        initLists();
        setAnswers();
    }

    private void initLists(){
        a1.add(d11a11);
        a1.add(a12);
        a1.add(a13);
        a1.add(a14);
        a1.add(d71a15);
        d1.add(d11a11);
        d1.add(d12);
        a2.add(a21);
        a2.add(d73a22);
        a2.add(a23);
        a3.add(d52a31);
        a3.add(d61a32);
        a3.add(a33);
        a3.add(d75a34);
        a3.add(a35);
        a3.add(a36);
        a3.add(d81a37);
        a4.add(a41);
        a4.add(a42);
        a4.add(d53a43);
        a4.add(d62a44);
        d5.add(d51);
        d5.add(d52a31);
        d5.add(d53a43);
        d7.add(d71a15);
        d7.add(d72);
        d7.add(d73a22);
        d7.add(d74);
        d7.add(d75a34);
    }

    public void handleHome(ActionEvent event) throws IOException{
        crosswordPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../Main.fxml")));
        Scene scene = new Scene(crosswordPane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void setCrosswordClues() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/application/down.csv"));
            String line = br.readLine();
            String wholeFile = "";
            while (line != null) {
                String splitString[] = line.split(",");
                wholeFile += splitString[0] + ". " + splitString[1] + "\n";
                line = br.readLine();
            }
            downClues.setText(wholeFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/application/across.csv"));
            String line = br.readLine();
            String wholeFile = "";
            while (line != null) {
                String splitString[] = line.split(",");
                wholeFile += splitString[0] + ". " + splitString[1] + "\n";
                line = br.readLine();
            }
            acrossClues.setText(wholeFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAnswers(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/application/across.csv"));
            String line = br.readLine();
            while (line != null) {
                String splitLine[] = line.split(",");
                acrossAnswers.add(splitLine[2]);
                line = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/application/down.csv"));
            String line = br.readLine();
            while (line != null) {
                String splitLine[] = line.split(",");
                downAnswers.add(splitLine[2]);
                line = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showAnswers(){
        //for loops setting answers
        for (int i = 0; i < a1.size(); i++){
            a1.get(i).setText(acrossAnswers.get(0).charAt(i) + "");
        }

        for (int i = 0; i < a2.size(); i++){
            a2.get(i).setText(acrossAnswers.get(1).charAt(i) + "");
        }

        for (int i = 0; i < a3.size(); i++){
            a3.get(i).setText(acrossAnswers.get(2).charAt(i) + "");
        }

        for (int i = 0; i < a4.size(); i++){
            a4.get(i).setText(acrossAnswers.get(3).charAt(i) + "");
        }

        for (int i = 0; i < d1.size(); i++){
            d1.get(i).setText(downAnswers.get(0).charAt(i) + "");
        }

        for (int i = 0; i < d5.size(); i++){
            d5.get(i).setText(downAnswers.get(1).charAt(i) + "");
        }

        for (int i = 0; i < d7.size(); i++){
            d7.get(i).setText(downAnswers.get(3).charAt(i) + "");
        }
    }

    public void checkAnswers(){
        String input = "";
        for (int i = 0; i < a1.size(); i++){
            input += a1.get(i).getText();
        }
        if (input.equalsIgnoreCase(acrossAnswers.get(0))) {
            for (int i = 0; i < a1.size(); i++) {
                a1.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < a1.size(); i++) {
                a1.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < a2.size(); i++){
            input += a2.get(i).getText();
        }
        if (input.equalsIgnoreCase(acrossAnswers.get(1))) {
            for (int i = 0; i < a2.size(); i++) {
                a2.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < a2.size(); i++) {
                a2.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < a3.size(); i++){
            input += a3.get(i).getText();
        }
        if (input.equalsIgnoreCase(acrossAnswers.get(2))) {
            for (int i = 0; i < a3.size(); i++) {
                a3.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < a3.size(); i++) {
                a3.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < a4.size(); i++){
            input += a4.get(i).getText();
        }
        if (input.equalsIgnoreCase(acrossAnswers.get(3))) {
            for (int i = 0; i < a4.size(); i++) {
                a4.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < a4.size(); i++) {
                a4.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < d1.size(); i++){
            input += d1.get(i).getText();
        }
        if (input.equalsIgnoreCase(downAnswers.get(0))) {
            for (int i = 0; i < d1.size(); i++) {
                d1.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < d1.size(); i++) {
                d1.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < d5.size(); i++){
            input += d5.get(i).getText();
        }
        if (input.equalsIgnoreCase(downAnswers.get(1))) {
            for (int i = 0; i < d5.size(); i++) {
                d5.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < d5.size(); i++) {
                d5.get(i).setStyle("-fx-text-fill: red");
            }
        }

        input = "";
        for (int i = 0; i < d7.size(); i++){
            input += d7.get(i).getText();
        }
        if (input.equalsIgnoreCase(downAnswers.get(3))) {
            for (int i = 0; i < d7.size(); i++) {
                d7.get(i).setStyle("-fx-text-fill: green");
            }
        }
        else {
            for (int i = 0; i < d7.size(); i++) {
                d7.get(i).setStyle("-fx-text-fill: red");
            }
        }
    }
}
