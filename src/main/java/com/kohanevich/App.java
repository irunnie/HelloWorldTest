package com.kohanevich;


import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class App
{
    private static final Logger log = Logger.getLogger(App.class);

    private final static String morning = "morning";
    private final static String day = "day";
    private final static String evening = "evening";
    private final static String night = "night";

    public static void main( String[] args )
    {
        Locale.getDefault();
//        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle");

        String phase = new Service().getPhaseOfTheDay();
        if(phase.equals(morning)){
            log.info("morning branch");
            System.out.println(resourceBundle.getString(morning));
        }
        else if(phase.equals(day)){
            log.info("day branch");
            System.out.println(resourceBundle.getString(day));
        }
        else if(phase.equals(evening)){
            log.info("evening branch");
            System.out.println(resourceBundle.getString(evening));
        }
        if(phase.equals(night)){
            log.info("night branch");
            System.out.println(resourceBundle.getString(night));
        }
    }
}
