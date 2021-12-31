package application.model;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Classifieds {
    public ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
    int numberOfAds = 0;

    //not sure if constructor should be empty for loadAds or not
    public Classifieds(Advertisement arr[], int innumberOfAds){
        //adds all advertisements to the Classifieds.fxml object's ads ArrayList
        for (int i = 0; i < innumberOfAds; i++){
            this.ads.add(arr[i]);
        }
        this.numberOfAds = innumberOfAds;
    }

    public Classifieds(int innumberOfAds){
        this.numberOfAds = innumberOfAds;
        this.ads = new ArrayList<Advertisement>();
    }

    //reads ads in from a passed string
    public void loadAds(String fileName){
        //System.out.println("Entered loadAds");
        //tries opening csv reader, catches exceptions
        try{
            FileReader fr = new FileReader(fileName); //needs actual source ex src/ads.csv, otherwise throws exception
            //System.out.println("After filereader");
            BufferedReader br = new BufferedReader(fr);
            //System.out.println("Made it past opening buffered reader");
            //for passing to Advertisement constructor
            boolean isFullTime;
            //reads until no more to read
            String line = br.readLine(); //reads in first line here to keep from skipping lines
            while (line != null){
                //System.out.println("Opened buffer and entered while");
                //holds a string to be split
                String[] splitString = line.split(","); //splits lines at ,
                //checks if the job ad is a full time job and sets isFullTime accordingly
                if (splitString[1].toLowerCase().equals("full")){
                    isFullTime = true;
                }
                else{
                    isFullTime = false;
                }
                //adds a new advertisement to the Classifieds.fxml object
                this.ads.add(new Advertisement(splitString[0], splitString[2], isFullTime, splitString[4], splitString[3]));
                this.numberOfAds++;
                line = br.readLine(); //updates line with next line
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    //has two separate loops because new ads may not be the same amount as old adds
    public void setAds(Advertisement arr[], int innumberOfAds){
        //removes all old adds
        for (int i = 0; i < this.numberOfAds; i++){
            this.ads.remove(i);
        }

        //adds in new adds
        for (int i = 0; i < innumberOfAds; i++){
            this.ads.add(arr[i]);
        }
    }

    public ArrayList<Advertisement> getAds(){
        return this.ads;
    }

    public void setNumberOfAds(int innumberOfAds){
        this.numberOfAds = innumberOfAds;
    }

    public int getNumberOfAds(){
        return this.numberOfAds;
    }
}
