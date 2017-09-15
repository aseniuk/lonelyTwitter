package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aseniuk on 9/14/17.
 */

public class SadMood extends Mood {
    public SadMood(String message){
        super(message);

    }
    public SadMood(String message, Date date) {
        super(message, date);
    }
    @Override
    public Boolean isHappy() {
        return Boolean.TRUE;
    }

}
