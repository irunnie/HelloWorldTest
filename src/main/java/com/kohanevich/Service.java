package com.kohanevich;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Service {

    private static final Logger log = Logger.getLogger(Service.class);

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
            Date morning = dateFormat.parse(DayPhases.MORNING.getTime());
            Date day = dateFormat.parse(DayPhases.DAY.getTime());
            Date evening = dateFormat.parse(DayPhases.EVENING.getTime());
            Date night = dateFormat.parse(DayPhases.NIGHT.getTime());

            if(actual.after(morning) && actual.before(day)){
                phase = "MORNING";
            }
            else if(actual.after(day) && actual.before(evening)){
                phase = "DAY";
            }
            else if(actual.after(evening) && actual.before(night)){
                phase = "EVENING";
            }
            else{
                phase = "NIGHT";
            }

        } catch (ParseException e) {
            log.error("Something wrong here! -> " + e.getMessage());
        }

        log.info("Current phase of the day is " + phase);
        return phase;
    }
}
