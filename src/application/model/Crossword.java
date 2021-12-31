package application.model;

import java.io.*;
import java.util.*;

public class Crossword {
    public ArrayList<String> across = new ArrayList<String>();
    public ArrayList<String> down = new ArrayList<String>();

    //loads data from files to object in ArrayList form
    public void loadData(String firstFile, String secondFile){
        //trys opening buffered readers for files, catches exceptions
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(firstFile));
            BufferedReader br2 = new BufferedReader(new FileReader(secondFile));
            //holds strings for formatting purposes
            String stringHolder;
            //reads until no more to read
            while (br1.readLine() != null){
                //replacing commas with spaces in strings (expecting csv)
                stringHolder = br1.readLine().replace(',', ' ');
                this.across.add(stringHolder);
            }
            br1.close();
            while (br2.readLine() != null){
                stringHolder = br2.readLine().replace(',', ' ');
                this.down.add(stringHolder);
            }
            br2.close();
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    //getters
    public ArrayList<String> getAcross(){
        return this.across;
    }

    public ArrayList<String> getDown(){
        return this.down;
    }

    //setters
    public void setAcross(String newHint, int index){
        //removes at index then adds at index
        //didn't understand replace syntax
        this.across.remove(index);
        this.across.add(index, newHint);
    }

    public void setDown(String newHint, int index){
        this.down.remove(index);
        this.down.add(index, newHint);
    }
}
