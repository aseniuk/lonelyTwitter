package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aseniuk on 9/14/17.
 */

//Abstract Class - Mood

public abstract class Mood {
    private String message;
    private Date date;

    public Mood(String message){
        this.message = message;
        this.date = new Date();
    }

    public Mood(String message, Date date){
        this.message = message;
        this.date = date;

    }

    public void setDate(Date date){
        this.date = date;
    }


    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140) {
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    public String getMessage(){
        return message;
    }

    public abstract Boolean isHappy();

}






