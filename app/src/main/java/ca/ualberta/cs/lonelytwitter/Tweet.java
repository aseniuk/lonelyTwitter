package ca.ualberta.cs.lonelytwitter;


import java.util.ArrayList;
import java.util.Date;


/**
 * Created by aseniuk on 9/14/17.
 */


public abstract class Tweet implements Tweetable{
    private String message;
    private Date date;
    private ArrayList<Mood> moods;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
        this.moods = new ArrayList<Mood>();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;

    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate() {return date;}

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140) {
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }


    public String getMessage(){
        return message;
    }

    public void addMood(Mood mood) {
        this.moods.add(mood);
    }

    public String getMoods(){
        String mood_list ="";
        for (Mood m : moods){
            mood_list = mood_list + m.getMood() + " ";

        }
        return mood_list;
    }

    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}
