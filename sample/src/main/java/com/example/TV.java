package com.example;

public class TV extends ElectronicDevice{
    public TV(){};
    public TV(String imei, String status){
        this.name = imei;
        this.status = status;
    }
}
