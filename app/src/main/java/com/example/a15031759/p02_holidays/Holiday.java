package com.example.a15031759.p02_holidays;

/**
 * Created by 15031759 on 28/4/2017.
 */

public class Holiday {
    private String type;
    private String holiday;
    private int resourceID;
    private String date;
    private String info;

    public Holiday(String type, String holiday, int resourceID, String date, String info) {
        this.type = type;
        this.holiday = holiday;
        this.resourceID = resourceID;
        this.date = date;
        this.info = info;
    }
    public String getType(){
        return type;
    }
    public String getHoliday() {
        return holiday;
    }
    public int getResourceID() {
        return resourceID;
    }
    public String getDate(){
        return date;
    }
    public String getInfo(){
        return info;
    }


}
