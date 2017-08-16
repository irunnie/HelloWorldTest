package com.kohanevich;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */

public class ServiceTest {

    private Service service = new Service();

    @Test
    public void morningTest(){
        service.setCurrentDate("6:00:01");
        assertEquals(service.getPhaseOfTheDay(), "morning");
    }

    @Test
    public void dayTest(){
        service.setCurrentDate("10:51:22");
        assertEquals(service.getPhaseOfTheDay(), "day");
    }

    @Test
    public void eveningTest(){
        service.setCurrentDate("21:22:01");
        assertEquals(service.getPhaseOfTheDay(), "evening");
    }

    @Test
    public void nightTest(){
        service.setCurrentDate("06:00:00");
        assertEquals(service.getPhaseOfTheDay(), "night");
    }
}
