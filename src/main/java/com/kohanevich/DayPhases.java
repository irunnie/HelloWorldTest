package com.kohanevich;

public enum DayPhases {
    MORNING("06:00:00"),
    DAY("09:00:00"),
    EVENING("19:00:00"),
    NIGHT("23:00:00");

    private final String time;

    DayPhases(String time){
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
