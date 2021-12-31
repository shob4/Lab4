package application.model;

public class Advertisement {
    //class variables
    public String field;
    public String phoneNumber;
    public boolean isFullTime;
    public String datePosted;
    public String posterName;

    //constructor
    Advertisement(String infield, String inphoneNumber, boolean inisFullTime, String indatePosted, String inposterName){
        this.field = infield;
        this.phoneNumber = inphoneNumber;
        this.isFullTime = inisFullTime;
        this.datePosted = indatePosted;
        this.posterName = inposterName;
    }

    public void setField(String infield){
        this.field = infield;
    }

    public void setPhoneNumber(String inphoneNumber){
        this.phoneNumber = inphoneNumber;
    }

    public void setIsFullTime(boolean inisFullTime){
        this.isFullTime = inisFullTime;
    }

    public void setDatePosted(String indatePosted){
        this.datePosted = indatePosted;
    }

    public void setPosterName(String inposterName){
        this.posterName = inposterName;
    }

    public String getField(){
        return this.field;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public boolean getIsFullTime(){
        return this.isFullTime;
    }

    public String getDatePosted(){
        return this.datePosted;
    }

    public String getPosterName(){
        return this.posterName;
    }
}
