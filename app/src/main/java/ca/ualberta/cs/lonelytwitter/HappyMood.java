package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aseniuk on 9/14/17.
 */

public class HappyMood extends Mood {
    public HappyMood(String message){
        super(message);

    }

    public HappyMood(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isHappy() {
        return Boolean.FALSE;
    }

}
