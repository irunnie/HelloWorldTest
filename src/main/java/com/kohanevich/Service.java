package com.kohanevich;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Service {

    private static final Logger log = Logger.getLogger(Service.class);

    final private String MORNING = "06:00:00";
    final private String DAY = "09:00:00";
    final private String EVENING = "19:00:00";
    final private String NIGHT = "23:00:00";

    private Date currentDate;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Service(){
        currentDate = new Date();
    }

    public void setCurrentDate(String currentTime) {
        try {
            this.currentDate = dateFormat.parse(currentTime);
        } catch (ParseException e) {
            log.error("Something wrong with setting date " + e.getMessage());
        }
    }

    public String getPhaseOfTheDay(){

        String phase = null;
        try {

            Date actual = dateFormat.parse(dateFormat.format(currentDate));
            Date morning = dateFormat.parse(MORNING);
            Date day = dateFormat.parse(DAY);
            Date evening = dateFormat.parse(EVENING);
            Date night = dateFormat.parse(NIGHT);

            if(actual.after(morning) && actual.before(day)){
                phase = "morning";
            }
            else if(actual.after(day) && actual.before(evening)){
                phase = "day";
            }
            else if(actual.after(evening) && actual.before(night)){
                phase = "evening";
            }
            else{
                phase = "night";
            }

        } catch (ParseException e) {
            log.error("Something wrong here! -> " + e.getMessage());
        }

        log.info("Current phase of the day is " + phase);
        return phase;
    }
}
